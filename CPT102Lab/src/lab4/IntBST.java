package lab4;

import java.util.stream.IntStream;

public class IntBST {
    IntBTNode root;
    int count;
	 
    /* Constructor */
    public IntBST(){
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty(){
        return root == null;
    }
    /* Functions to insert data */
    public void insert(int data){
        root = insert(root, data);
    }
    /* Function to insert data recursively */
    private IntBTNode insert(IntBTNode node, int data){
        if (node == null){
            node = new IntBTNode(data);
            return node;
        }  
        if (data < node.data)
        	node.left = insert(node.left, data);
        else
        	node.right = insert(node.right,data);    	    
        return node;
    } 

    
    /* Function to search for an element */
    public boolean search(int data){
        return search(root, data);
    }
    
    /* Function to search for an element recursively */
    private boolean search(IntBTNode node, int data){
        if(node == null) return false;
        if(node.data == data) return true;
        return node.data > data ? search(node.left,data): search(node.right,data);
               
    }
    
    public void delete(int data){
    
        root = delete(root, data);
    
    }
    private IntBTNode delete(IntBTNode node, int data){
        
        //Base Case: If the tree is empty 
        if (node == null)  return node;
 
        //Otherwise, recur down the tree 
        if (data < node.data)
            node.left = delete(node.left, data);
        else if (data > node.data)
            node.right = delete(node.right, data);
 
        //if key is same as root's key, then This is the node to be deleted 
        else{
            // node with only one child or no child
            // TODO: student's code here.
        	if(node.left == null && node.right ==null) {
        		node  = null;
        	}
        	else if(node.left == null) {
            	node = node.right;
            	node.right = null;
            }
            else if(node.right == null) {
            	node = node.left;
            	node.left = null;
            }
 
            // node with two children: Get the inorder successor (smallest
            // in the right subtree), and delete the inorder successor. 
            // TODO: student's code here.
            else {
				IntBTNode successor = node.right;
				IntBTNode parent = null;
				while(successor.left != null) {
					parent = successor;
					successor = successor.left;
					
				}
				
				node.data = successor.data;
				
				if(parent !=null)
					parent.left = successor.right;
				
				else {
					node.right =successor.right;
				}					
	
				
			}
        }
 
        return node;
        
    }
    
    /* Function for inorder traversal */
    public void inorder(){
        
        root.inorderPrint();
    }
    
    /* Function for preorder traversal */
    public void preorder(){
        
        root.preorderPrint();
    }
    
    /* Function for postorder traversal */
    public void postorder(){
        
        root.postorderPrint();
    }
      
    public void printRange(int k1, int k2){
        
        if(k1 <= k2) printRangeUtil(this.root, k1, k2);
    }
    
    private void printRangeUtil(IntBTNode node, int k1, int k2) {
         
        //base case 
        //TODO: Student's code here.
    	if(node.data < k1 || node.data > k2)
    		return;
        //If node's data is greater than k1, then only we can get data(key)
        // in left subtree 
        //TODO: Student's code here.
    	if(node.data > k1 && node.left != null)
    		printRangeUtil(node.left, k1, k2);
        //If node's data lies in range, then prints node's data */
        //TODO: Student's code here.
    	if(node.data >= k1 && node.data <= k2)
    		System.out.printf(node.data+" ");
        //If node's data is smaller than k2, then only we can get data(key)
        // in right subtree 
        //TODO: Student's code here.
    	if(node.data < k2 && node.right != null)
    		printRangeUtil(node.right, k1, k2);
    }
    
    /* Fouction to find the kth largest key in given BST */
    public void kthLargest(int k){   
        count = 0;
        this.kthLargestUtil(this.root, k);
    }
 
    /* utility function to find kth largest no in a given tree */
    private void kthLargestUtil(IntBTNode node, int k){
        //TODO: Student's code here.
    	if(node.right != null) {
       		kthLargestUtil(node.right, k);
    	}
    	
    	count++;
    	
    	if(count == k) {
    		System.out.println(node.data);
    		return;
    	}
    	
    	if(node.left != null ) {
    		kthLargestUtil(node.left, k);
    	}
    	
    	

    		

 
    }
}
