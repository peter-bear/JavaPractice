package Trees;

public class RedBlackTree {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Node root;
	
	public RedBlackTree(){
		root =null;
	}
	
	/*Check Empty*/
	public boolean isEmpty() {
		return root == null;
	}
	
	
	/*Insert a new Node*/
	public void insert(int data) {
		 insertion(data);
	}
	
	/*Function to insert a node recursively*/
	private void insertion(int data) {
		
		Node cur = this.root;
		Node parent=null;
		
		/*Use a loop to find the final position*/
		while(cur!=null) {
			parent =cur;
			if(data < cur.data) {
				cur = cur.left;
			}else if(data > cur.data) {
				cur = cur.right;
			}else {
				return;
			}
		}
		
		/*Create a new node*/
		/*The default color is red*/
		Node node = new Node(data);
		node.parent =parent;
		
		/*if is empty, make the root point to this new node*/
		/*if not empty, find which position, the new node should be placed*/
		if(isEmpty()) {
			node.color = Black; //the root's color should be black
			this.root = node;
		}else {
			if(node.data < parent.data)
				parent.left = node;
			else {
				parent.right = node;
			}
		}
	
		/*after inserting the new node, we need to balance the tree*/
		balanceInsertion(node);

	}
	
	private void balanceInsertion(Node node) {
		Node parent, gparent; //two nodes, one for parent, the other for grandparent
		
		/*if parent's color is red, to fit the requirement: cannot have two red nodes together*/
		/*We need to balance the tree*/
		while((parent = node.parent)!= null && parent.color == Red) {
			gparent = parent.parent;
			
			/*to help us get the uncle node*/
			if(gparent.left == parent) {
				//we get the uncle node
				Node uncle= gparent.right;
				/*if uncle is red*/
				if(uncle.color == Red) {
					/*Make parent Black, uncle Black, grandparent Red*/
					parent.color = Black;
					uncle.color = Black;
					gparent.color = Red;
					
					/*Recursive*/
					node = gparent;
					continue;
				
				}else {
					/*if uncle color is black and parent's color is red*/
					
					//if this node is on parent's right
					if(parent.right == node) {
						leftRonate(parent);
						Node temp = node;
                        node = parent;
                        parent = temp;
					}
					parent.color = Black;
					gparent.color = Red;
					rightRonate(gparent);
				}
				
			}else {
				//get uncle node
				Node uncle = gparent.left; 
				if(uncle!=null&&uncle.color == Red) {
					/*same as before*/
					parent.color = Black;
					uncle.color = Black;
					gparent.color =Red;
					/*Still Recursive*/
					node = gparent;
					continue;
					
				}else {
					//the node is one the parent's left	
					if(parent.left == node) {
                        rightRonate(parent);
                        Node temp = node;
                        node = parent;
                        parent = temp;
					}
					
					parent.color = Black;
					gparent.color = Red;
					leftRonate(gparent);
				}
			}
		}
		
		//after balance, we need to check again, whether the tree fit the requirement
		if(this.root == node) {
			node.color = Black;
		}
	}

	
	/*Rotate left: Parent Current Grandparent are in one line*/
//	private void RotateLeftLine(Node root) {
//		/*Rotate*/
//		Node temp = root.right;
//		root.right = root.right.left;
//		if(temp.left != null)
//			temp.left.parent = root;
//		if(root.parent!=null) {
//			if(root.data < root.parent.data) {
//				root.parent.left = temp;
//			}else {
//				root.parent.right = temp;
//			}
//			
//		}else {
//			root = temp;
//			temp.parent = null;
//		}
//		temp.parent = root.parent;
//		
//		temp.left = root;
//		
//		root.parent = temp;
//		root = temp;
//		
//		/*change the color*/
//		int tempcolor = root.color;
//		root.color = root.left.color;
//		root.left.color = tempcolor;
//	}
//	
//	/*Rotate left: Parent Current Grandparent are not in a line*/
//	private void RotateLeftTri(Node root) {
//		RotateRightLine(root.right);
//		RotateLeftLine(root);
//	}
//	
//	
//	/*Rotate right: Parent Current Grandparent are in one line*/
//	private void RotateRightLine(Node root) {
//		/*Rotate*/
//		Node temp = root.left;
//		root.left = root.left.right;
//		
//		if(temp.right != null)
//			temp.right.parent = root;
//		if(root.parent!=null) {
//			if(root.data < root.parent.data) {
//				root.parent.left = temp;
//			}else {
//				root.parent.right = temp;
//			}
//			
//		}else {
//			root = temp;
//			temp.parent = null;
//		}
//		
//		temp.parent = root.parent;
//		
//		temp.right = root;
//		
//		root.parent = temp;
//		
//		root = temp;
//		
//		/*change the color*/
//		int tempcolor = root.color;
//		root.color = root.right.color;
//		root.right.color = tempcolor;
//	}
//	
//	/*Rotate right: Parent Current Grandparent are not in a line*/
//	private void RotateRightTri(Node root) {
//		RotateLeftLine(root.left);
//		RotateRightLine(root);
//	}
	
	public void leftRonate(Node x) {
		 
        //右孩子
		Node y = x.right;
 
        if (y.left != null) {
            //当前节点 变成了 右孩子的左节点的父亲
            y.left.parent = x;
        }
        x.right = y.left;
        y.left = x;
        //当前的父亲变成了右孩子的父亲
        y.parent = x.parent;
 
        if (x.parent != null) {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        } else {
            this.root = y;
        }
        x.parent = y;
 
    }
 
    //对某个节点进行右旋
    public void rightRonate(Node x) {
    	Node y = x.left;
 
        if (y.right != null) {
            y.right.parent = x;
 
        }
 
        y.parent = x.parent;
        x.left = y.right;
        y.right = x;
 
        if (x.parent != null) {
            if (x.parent.left == x) {
                x.parent.left = y;
 
            } else {
                x.parent.right = y;
 
            }
 
        } else {
            this.root = y;
 
        }
        x.parent = y;
 
    }
 
	
	
	
	
	/*Delete a node with specific data*/
	public void Delete(int data) {
		Node node;
		/*To find the node*/
		if((node = Search(root, data))!= null) {
			Delete(node);		
		}
		
	}
	
	/*Function for delete*/
	private void Delete(Node node) {
		Node child, parent, replace;
		int color =Black;
		
		/**we divide the delete into two situations
		 * 1 two child nodes are not null
		 * 2 one or two child nodes are null
		 */
		
		if(node.left != null && node.right != null) {
			//we use the successor node to replace the node
			replace = successor(node);
			parent = replace.parent; 
			child = replace.right; //child > replace but child < parent
			
			color = replace.color; //(replace's node's color)
			
			/*if node is replace's parent*/
			if(node == parent) {
				//delete node directly
				parent = replace;
				
			}else {
				if(child != null) {
					//because later we will delete replace node
					child.parent = replace.parent;
				}
				
				//switch the replace node and deleted node
				replace.parent.left = child;
				replace.right = node.right;
				//set deleted node's rightchild's parent as replace node 
				node.right.parent = replace;
			}
			
			//set replace's parent as deleted node's parent
			replace.parent = node.parent;
			replace.left = node.left;
			//set deleted node's leftchild's parent as replace node 
			node.left.parent = replace;
			
			//after switch their position, we also need to change their color
			replace.color = node.color;
			
			//we need to change node's parent's pointer again
			if(node.parent!=null) {
		       if (node.parent.left == node) {
                    node.parent.left = replace;
                } else {
                    node.parent.right = replace;
                }
			}else {
				this.root = replace;
			}
			
			//after replacing the node, we need to check the balance
			//if the replace node's color is black
			if(color == Black) {
				balanceDeletion(child, parent);
			}
			
		}else {
			//the deleted node only have one left node or right node or null
			if(node.left !=null)
				replace = node.left;
			else {
				replace =node.right;
			}
			
			//find the delete node's parent
			parent = node.parent;
			if(parent != null) {
				if(parent.left == node) {
					parent.left = replace;
				}else {
					parent.right = replace;
				}
			}else {
				this.root = replace;
			}
			
			//if replace is not null, 
			if(replace != null) {
				replace.parent = parent;
				if(node.color == Black) {
					balanceDeletion(replace, parent);
				}
				
			}
		}
	}
	
	/*Search The node*/
	private Node Search(Node root, int data) {
		if(root != null) {
			/*Use recursive method*/
			if(data < root.data)
				return Search(root.left, data);
			else if(data > root.data)
				return Search(root.right, data);
			else {
				return root;
			}
		}
		return null;
	}
	
	
	/*To get the successor node*/
	private Node successor(Node node) {
		if(node.right != null) {
			return min(node.right);
		}
		return null;
	}
	
	private Node min(Node node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	
	
	/*BalanceDeletion*/
	private void balanceDeletion(Node child, Node parent) {
		Node other;
		while(child!=null&&child.color == Black && child != this.root) {
			
			if(parent.left == child) {
				//if the replace node is on the left
				other = parent.right;
				//brother's color is red, and father's colro is black
				if(other.color == Red) {
					parent.color = Red;
					other.color =Black;
					leftRonate(parent);
					continue;
				}else {
								
						if((other.left == null && other.right == null)&&(other.left.color == Black)&&(other.right.color==Black)) {
							other.color = Red;
							
							//recursive
							child = parent;
							parent = child.parent;
						}else if(other.left != null && other.right != null&&other.left.color == Red && other.right.color == Black) {
							
							other.color = Red;
							other.left.color =Black;
							rightRonate(other);
							
						}else if(other.right!= null &&other.right.color == Red) {
							other.color = parent.color;
							parent.color = Black;
							other.right.color = Black;
							leftRonate(parent);
							break;
						}
				}
				
			}else {
				//if brother node is on the left, replace node is one the right
				other = parent.left;
				if(other.color == Red) {
					parent.color = Red;
					other.color =Black;
					rightRonate(parent);
					continue;
				}else {
					if((other.left == null && other.right == null)&&(other.left.color == Black)&&(other.right.color==Black)) {
						other.color = Red;
						
						//recursive
						child = parent;
						parent = child.parent;
					}else if(other.left != null && other.right != null&&other.right.color == Red && other.left.color == Black) {
						
						other.color = Red;
						other.right.color =Black;
						leftRonate(other);
						
					}else if(other.left!= null &&other.left.color == Red) {
						other.color = parent.color;
						parent.color = Black;
						other.left.color = Black;
						rightRonate(parent);
						break;
					}
				}
				
			}
		}
		if(child!=null)
			child.color = Black;
	}
	
	/*inorder travel*/
	public void inOrder() {
		inOrder(this.root);
	}
	
    //中序遍历
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node);
            inOrder(node.right);
        }
 
    }
	
	
	
	/*Two properties, 0 represents red, 1 represents black*/
	private final static int Red = 0;
	private final static int Black =1;
	
	
	/**
	 * 
	 * @author 23881
	 * create a node
	 * include two pointer, one for left, the other for right
	 * include a data (generic type)
	 */
	private static class Node{
		Node left;
		Node right;
		Node parent;
		int color= Red; //default color is red
		int data;
		
		Node(int data){
			this.data =data;
			left = null;
			right =null;
			parent = null;
		}
		
		Node(int d, Node l, Node r, Node p){
			data = d;
			left =l;
			right =r;
			parent =p;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[ data= "+data+" , color= "+color+" ]";
		}
		
		
		
		
	}
}
