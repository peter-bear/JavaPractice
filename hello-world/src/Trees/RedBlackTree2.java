


package Trees;
 
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
 
 
/**
 * �����-Javaʵ������
 */
public class RedBlackTree2<T extends Comparable<T>, D> {
 
    private RBNode<T, D> root;//���ڵ�
    /**
     * �ڵ����ɫ
     */
    private static final Boolean RED = false;
    private static final Boolean BLACK = true;
 
    public class RBNode<T extends Comparable<T>, D> {
 
        private Boolean color;//�ڵ���ɫ
        private T key;//��ֵ
        private D data;//���������
        private RBNode<T, D> parent;
        private RBNode leftChild;
        private RBNode rightChild;
 
 
        public RBNode(Boolean col, T key, D data, RBNode paret, RBNode leftChild, RBNode rightChild) {
            this.color = col;
            this.key = key;
            this.data = data;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
 
        }
 
    }
 
    /**
     * ��ȡ����
     *
     * @param node
     * @return
     */
    public RBNode<T, D> parentOf(RBNode<T, D> node) {
        if (node != null) {
            return node.parent;
 
        }
 
        return null;
 
    }
 
    /**
     * ��ȡ��ɫ
     *
     * @param node
     * @return
     */
    public Boolean colorOf(RBNode<T, D> node) {
        if (node != null) {
            return node.color;
 
        }
        return BLACK;
 
    }
 
    public void setParent(RBNode<T, D> node, RBNode<T, D> parent) {
        if (node != null) {
            node.parent = parent;
        }
 
    }
 
    public void setColor(RBNode<T, D> node, Boolean color) {
        if (node != null) {
            node.color = color;
 
        }
 
    }
 
    public Boolean isRed(RBNode<T, D> node) {
        return (node != null && node.color == RED) ? true : false;
 
    }
 
    public Boolean isBlack(RBNode<T, D> node) {
        return !isRed(node);
 
    }
 
    public void setRed(RBNode<T, D> node) {
        if (node != null) {
            node.color = RED;
        }
    }
 
    public void setBlack(RBNode<T, D> node) {
        if (node != null) {
            node.color = BLACK;
        }
 
    }
 
    /**
     * ����key��ȡ����
     *
     * @param key
     * @return
     */
    public D get(T key){
        RBNode node = search(key, root);
        return node == null ? null : (D) node.data;
    }
 
    //Ѱ��Ϊkeyֵ�Ľڵ�
    public RBNode<T, D> search(T key, RBNode<T, D> node) {
 
        if (node != null) {
            //���ҵĹ��̣�����һֱ�ݹ�Ƚϵ�Ҷ��Ϊֹ
            int com = key.compareTo(node.key);
            if (com < 0) {
                return search(key, node.leftChild);
            } else if (com > 0) {
                return search(key, node.rightChild);
            } else {
                return node;
            }
 
        }
        return null;
 
 
    }
 
    //Ѱ�Һ�̽ڵ㣬�����ڸýڵ����С�ڵ�
    public RBNode<T, D> min(RBNode<T, D> node) {
 
        //һֱ�����ߣ�����˵ľ�����Сֵ�����Ƕ�����������
        if (node.leftChild == null) {
            return node;
        }
        while (node.leftChild != null) {
            node = node.leftChild;
        }
 
        return node;
    }
 
    /**
     * Ѱ�Ҵ�ɾ�ڵ�ĺ�̽ڵ�
     * ����Ϊ����ڵ㼴��Ҫ��ɾ�ˣ�����Ҫѡ����̽ڵ㲹�����λ������
     *  ѡ��ڵ�Ĺ���
     *  ����������ͨ��������һ���ģ�Ҫô�����������������ֵ��Ҫô��������������Сֵ��
     *
     * @param node
     * @return
     */
    public RBNode successor(RBNode<T, D> node) {
 
        if (node.rightChild != null) {
            return min(node.rightChild);
        }
        //���������ǲ������ģ���Ϊֻ��node���������Ӷ���Ϊnullʱ�Ż�����������
        RBNode<T, D> y = node.parent;
        while ((y != null) && (y.rightChild == node)) {
            node = y;
            y = y.parent;
 
        }
        return y;
 
    }
 
    /**
     * ��ĳ���ڵ��������
     * ����ǰ�ڵ���Ǹ��׽ڵ㣬������̾��� �����³����Һ���������Ȼ���Һ��ӵ���ڵ�����ԭ���׵��ҽڵ㣩
     *
     * @param x
     */
    public void leftRonate(RBNode<T, D> x) {
 
        //�Һ���
        RBNode<T, D> y = x.rightChild;
 
        if (y.leftChild != null) {
            //��ǰ�ڵ� ����� �Һ��ӵ���ڵ�ĸ���
            y.leftChild.parent = x;
        }
        x.rightChild = y.leftChild;
        y.leftChild = x;
        //��ǰ�ĸ��ױ�����Һ��ӵĸ���
        y.parent = x.parent;
 
        if (x.parent != null) {
            if (x.parent.leftChild == x) {
                x.parent.leftChild = y;
            } else {
                x.parent.rightChild = y;
            }
        } else {
            this.root = y;
        }
        x.parent = y;
 
    }
 
    //��ĳ���ڵ��������
    public void rightRonate(RBNode<T, D> x) {
        RBNode<T, D> y = x.leftChild;
 
        if (y.rightChild != null) {
            y.rightChild.parent = x;
 
        }
 
        y.parent = x.parent;
        x.leftChild = y.rightChild;
        y.rightChild = x;
 
        if (x.parent != null) {
            if (x.parent.leftChild == x) {
                x.parent.leftChild = y;
 
            } else {
                x.parent.rightChild = y;
 
            }
 
        } else {
            this.root = y;
 
        }
        x.parent = y;
 
    }
 
 
 
    /**
     *
     * ��������ƽ�����
     *
     * ��Ϊʲô���������������ΪHashMapԴ��Ҳ�������Դ������
     *
     * @param node �²���Ľڵ�
     */
    public void balanceInsertion(RBNode<T, D> node) {
 
        RBNode<T, D> parent, gparent;//�������游
 
        //һ��ʼ����Ľڵ����ȿ϶��Ǻ�ɫ�����縸�ײ�Ϊ���Ҹ���Ҳ�Ǻ�ɫ���Ǿͳ����ˡ�˫�������
        //����������������ѭ��
        //���縸���Ǻ�ɫ��û��Ҫ������Ϊʲô��
        // ��Ϊ��һ����ڵ㣬����Ӱ������·���ϵĺ�ɫ�ڵ���������仯�����Բ���Ӱ������������
        while (((parent = parentOf(node)) != null) && isRed(parent)) {
 
            //�õ����׵ĸ��ף�Ҳ�����游
            gparent = parentOf(parent);
 
            //�����游���жϣ��������游��������������������ȷ����֮���Ŀ����Ϊ���õ��常
            if (gparent.leftChild == parent) {
                //���縸�����游�����ӣ���ͨ���游���Һ���ָ������õ��常
                RBNode<T, D> uncle = gparent.rightChild;
                //��һ�����ٷ�����������ᷢ���������������ǰ���Ǹ���Ϊ��ɫ ��
                if (isRed(uncle)) {
                    //�常�Ǻ�ɫ
                    //���ױ�ڣ��常��ڣ��游��� ��Ϊ��Ҫ������������ǹ��ɣ��ñʺ�ֽ������֪����
                    // ʵ�ڿ������ο��ҵıʼǣ�http://note.youdao.com/noteshare?id=14243cb721319c19ef8f79cadd2a2c81&sub=0B35BC1D6FD747DAB0C373910D1DBAB5
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    //���ݣ����ϣ���һ��ָ�븳ֵ�����游��ɵ�ǰ�ڵ㣬���������жϣ�ֱ����ֹ
                    node = gparent;
                    //������������ݹ��̽����������if-else��֧�����һ�Σ�Ϊ�Σ�
                    //��Ϊ�常һ��ʼ�Ǻ�ɫ����˵���游��Ϊ��ɫ�����游���ֵ�Ҳ�϶��Ǻ�ɫ����Ϊ��ɫ���ֵܽڵ㣬��Ȼͬɫ
                    //����һ��֮�󣬸��ױ���˵�ǰ�ڵ㣬ԭ�����游����˸��ף���˵���¸��ײ��������常ͬΪ��ɫ��
                    continue;
 
                } else {
                    //�常�Ǻ�ɫ������Ϊ��
                    if (parent.rightChild == node) {
                        //���統ǰ�ڵ��Ǹ��׵��Һ���
                        //����Ҫ����
                        leftRonate(parent);
                        RBNode<T, D> temp = node;
                        node = parent;
                        parent = temp;
 
                    }
                    //��Ϊ���淢����ָ�����������parent��ʵ�Ѿ�ָ��ǰ�ڵ��ָ��
                    // �����ǵ�ǰ�ڵ�λ��������ڣ������³����Ǻ�ɫ���游���
                    setBlack(parent);
                    setRed(gparent);
                    //�游����
                    //����Ϊʲô�游��Ҫ����һ���أ�
                    /*
                             ����               ����
                            /    \             /   \
                         �츸    ����  -->  ���   ����
                            \               /
                            ���          �츸
                         ���Կ������棬������һ����ת֮��ƽ������Ȼ���㣬������ɫ�Ͳ����ˣ���Ȼ����˫�����
                         ��ʵ�����AVL����ƽ�������������ʵҲ��һ����˫��ת���Ĺ��̣�ֻ�б�ɾ�ڵ��븸�ײ�ͬ��ʱ����Ҫ˫��
                         �������������˫���������Ϊ��ɫ���ԣ���ʱ��Ҫ��ɫ
                                    ����          ����
                                   /   \          /   \
                                ���   ���� --> �ڲ�  ����
                               /                /
                            �츸              �츸
                          ���Կ�������ɫ֮���ұߵ���������������ĺ�ɫ�ڵ��������һ�£����Ժ�ԭ����ͬ��ԭ����ͼ�������Ͻǣ��������ĺ�ɫ�ڵ�Ҫ��һ��
                          ԭ�������϶��������������ʵģ���������ֻ��Ҫ��һ�μ򵥵��������Ϳ������������ĺ�ɫ�ڵ�����ٴα���߶�һ����������ԭ�������
                     */
                    rightRonate(gparent);
 
                }
 
            } else {
                //ͬ�����ҵ��常
                RBNode<T, D> uncle = gparent.leftChild;
                if (isRed(uncle)) {
                    //���������ʵ��������� һ�µģ�����Ҫ��ת��ֻ��Ҫ����Ⱦɫ����
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;
                    continue;
 
                } else {
                    if (parent.leftChild == node) {
                        //���統ǰ����ڵ��Ǹ��׵����ӣ��ǾͶԸ���������
                        //���������������³�
                        rightRonate(parent);
                        RBNode<T, D> temp = node;
                        node = parent;
                        parent = temp;
                    }
                    //ͬ���游����
                    setBlack(parent);
                    setRed(gparent);
                    leftRonate(gparent);
 
                }
 
            }
 
        }
 
        //�����󣬼��綼�����������ˣ�����Ҫ�ٴμ��飬�ø�Ϊ��ɫ������������������������
        if (root == node) {
            setBlack(node);
        }
 
    }
 
    /**
     * �����ɾ�����ƽ�����
     * ��ɾ�������Ƚϸ��ӣ������Ҽ��˺ܶ����״̬׷�٣�
     *
     * @param node
     * @param parent
     *
     *               ���ֻ���������������������
     *               1. node=�滻�ڵ� parent=�滻�ڵ�ĸ��׽ڵ�
     *               2. node=�滻�ڵ�ĺ��ӽڵ� parent=�滻�ڵ�
     *               3. node=�滻�ڵ�ĺ��ӽڵ� parent=�滻�ڵ�ĸ��ڵ�
     *
     *               ������������������������㣺node��parent�Ƕ��Ӹ��׵Ĺ�ϵ
     *
     *               ����Ҫ�����ʲô����»���뵽���������
     *               1.��ɾ�ڵ��Ǻ�ɫ�ڵ㣨�Ҵ�ɾ�ڵ�ֻ��һ��������
     *               ����
     *               2.�滻�ڵ��Ǻ�ɫ�ڵ�(��ɾ�ڵ��������������Ϊ��)
     *
     *               ������ϸ�������������������Ϊ��ֻ������������£����б�Ҫ���е�����
     *               ������������1��
     *               ��ɾ�ڵ�ֻ��һ��������˵��ֻ��һ��·������ɾ�ڵ��Ƴ���֮��ֻ��Ӱ��һ��·���ϵĺ�ɫ�ڵ������
     *               �����º���������ʣ�ͬһ���ڵ����ֱ��Ҷ�ӣ�ÿһ����ͬ��·���µĺ�ɫ�ڵ������������ͬ�ġ�
     *               �Ǽ�Ȼ��ֻ��һ��������˵��ֻ��һ��·���������ɾ�ڵ��Ǻ�ɫ�����Ƴ���֮�󣬲���Ӱ������·���µĺ�ɫ�ڵ���������Բ���Ҫ������
     *               ��֮���������Ǻ�ɫ����һ�����Ƴ�����һ��·���ϵĺ�ɫ�����ͼ����ˣ������ᵼ����һ��·���ĺ�ɫ�ڵ�ֱ�Ӽ�һ
     *               �����ͻᵼ����һ��·���� ����������������·����ȣ�������ȡ�
     *
     *               ������������2��
     *               ��Ϊ��ɾ�ڵ��£���������������Ҫ�����������ֶ������Ĺ�ϵ���Ǵ�ɾλ���ϱ������һ�����Ϲ����Ԫ�ء�
     *               ����ʲô�����أ�Ҳ���Ǳ�����������󣬱�������С���������Ǳ����ͨ��ѡ����������Сֵ��
     *               ��ɾԪ�ر�ɾ����Ҫѡ����������Сֵ�ŵ���ɾԪ��λ�ã����滻�ڵ��ָ��ͻᶪʧ����Ϊ�����ƶ���
     *               ��Ȼ���������и�Ԫ�ر��Ƴ��ˣ�����������Ƴ�ָ����滻�ڵ㣬�Ǻ�ɫ���������������ƽ�������κ�Ӱ�졣
     *               ����������滻�ڵ��Ǻ�ɫ��һ�����Ƴ����ᵼ���������ĺ�ɫ������һ��������ȣ�������Ҫ������
     *
     *      ����һ�ε������̣���಻�ᳬ�����Σ�����Ϊʲô��
     *      ���������1�Ƚϼ򵥣�����Ҫ���κ���ת��ֻ��ҪȾɫ���ɡ�
     *      ���ӵ������2����
     *          ���2�ֿ��Է�Ϊϸ�����������
     *              1.�滻�ڵ����¸��׵����
     *              2.�滻�ڵ����¸��׵��Ҳ�
     *              (ֻҪ���������һ���������һ����ʵҲ�����)
     *
     *
     *              ����ֻѡ����һ����������ܽ�
     *              �����滻�ڵ����¸��׵��������������ֿ���ϸ�ֳɼ�������������⼸������������Ҿ��ú�������������Ĳ��֣���
     *                  1.�ֵܽڵ��Ǻ�ɫ���ֵܱ�ڣ����ױ�죬��������
     *                  2.�ֵܽڵ��Ǻ�ɫ
     *                    2.1.�ֵܽڵ�����Һ��Ӷ��Ǻ�ɫ���ֵ�Ⱦ�죬����ָ�루�����滻�ڵ����parent�����ϻ���һ��
     *                    2.2.�ֵܽڵ�������Ǻ�ɫ���Һ����Ǻ�ɫ���ֵ�Ⱦ�죬����Ⱦ�ڣ��ֵ�����
     *                    2.3.�ֵܽڵ���Һ����Ǻ�ɫ�����׵���ɫ��ֵ���ֵ�,����Ⱦ�ڣ��ֵܵ��Һ���Ⱦ�ڣ���������
     */
 
    public void balanceDeletion(RBNode<T, D> node, RBNode<T, D> parent) {
 
        //�ȿ��µ���֮ǰ�����ṹ
        System.out.println("�ȿ��µ���֮ǰ�����ṹ");
        this.printTreeLevel2();
 
        RBNode<T, D> other;
        while (isBlack(node) && node != this.root) {
 
            //��������ڵ����ɫҲΪ�ڣ�����ΪʲôҪ�á�Ҳ���֣��ܽ�����������϶�˵����ɾ�ڵ�Ҳ�Ǻ�ɫ
            //����ڵ�Ҳ�Ǻ�ɫ���ǿ϶�Ҫ�������ˣ���Ȼ����·����������һ����ɫ�ڵ㣬���տ϶��ǲ����Ϻ����������
 
            if (parent.leftChild == node) {
                //��������ڵ������¸��׵���ڵ㣬�Ǿ�ͨ����ָ���õ����ֵܽڵ�
                other = parent.rightChild;
 
                System.out.println("��ǰparent��" + parent.key + " other(�ֵܽڵ�):" + other.key);
 
                if (isRed(other)) {
                    //�����ֵ��Ǻ�ɫ����ô���׿϶��Ǻ�ɫ
 
                    System.out.println("�ֵܵ�ǰ�Ǻ�ɫ");
                    System.out.println("����balanceDeletion��while�����2-L-a:�ֵ��Ǻ�ɫ��");
                    System.out.println("----����Ⱦ�죬otherȾ�ڣ�����������Ȼ��continue");
 
 
                    //�ֵ��븸�׵�����ɫ������������
                    setRed(parent);
                    setBlack(other);
                    leftRonate(parent);
 
                    this.printTreeLevel2();
 
                    continue;
 
 
                } else {
                    if (isBlack(other.leftChild) && isBlack(other.rightChild)) {
                        //�����ֵܽڵ�û���κκ��ӽڵ㣬Ҳ�������������֧����ΪҶ��Ҳ�൱���Ǻ�ɫ��
 
                        //other�����滻�ڵ���ֵܽڵ�
                        System.out.println("�ֵܽڵ㵱ǰ�����Һ��Ӷ��Ǻ�ɫ");
                        System.out.println("����balanceDeletion��while�����2-L-b:�ֵܵ����Һ��Ӷ��Ǻ�ɫ��");
                        System.out.println("----otherȾ�죬����ָ�����ϻ���");
 
                        //otherȾ�죬����ָ�����ϻ���
                        setRed(other);
                        node = parent;
                        parent = parentOf(node);
 
                        this.printTreeLevel2();
 
 
                    } else if (isRed(other.leftChild) && isBlack(other.rightChild)) {
 
                        System.out.println("other��ǰ�������Ǻ�ɫ���Һ����Ǻ�ɫ");
                        System.out.println("����balanceDeletion��while�����2-L-c:�ֵܵ������Ǻ�ɫ���Һ����Ǻ�ɫ��");
                        System.out.println("----otherȾ�죬other����ڵ�Ⱦ�ڣ�other������");
 
                        setRed(other);
                        setBlack(other.leftChild);
                        rightRonate(other);
 
                        this.printTreeLevel2();
 
 
                    } else if (isRed(other.rightChild)) {
 
                        System.out.println("other�Һ����Ǻ�ɫ");
                        System.out.println("����balanceDeletion��while�����2-L-d:�ֵܵ��Һ����Ǻ�ɫ��");
                        System.out.println("----���׵���ɫ��ֵ��other,����Ⱦ�ڣ�other���Һ���Ⱦ�ڣ���������������whileѭ��");
 
                        setColor(other, colorOf(parent));
                        setBlack(parent);
                        setBlack(other.rightChild);
                        leftRonate(parent);
 
                        this.printTreeLevel2();
 
                        break;
 
                    }
 
                }
 
            } else {
                other = parent.leftChild;
 
                System.out.println("��ǰparent��" + parent.key + " other:" + other.key);
 
                if (isRed(other)) {
 
                    System.out.println("other��ǰ�Ǻ�ɫ");
                    System.out.println("����balanceDeletion��while�����2-R-a:�ֵ��Ǻ�ɫ��----otherȾ�ڣ�parent���,parent����");
 
                    setBlack(other);
                    setRed(parent);
                    rightRonate(parent);
 
                    this.printTreeLevel2();
 
                    continue;
 
                } else {
 
                    if (isBlack(other.leftChild) && isBlack(other.rightChild)) {
 
                        System.out.println("other��ǰ�������Ǻ�ɫ��other���Һ����Ǻ�ɫ");
                        System.out.println("����balanceDeletion��while�����2-R-b:�ֵܵ����Һ��Ӷ��Ǻ�ɫ��----other��죬ָ�����");
 
                        setRed(other);
                        node = parent;
                        parent = parentOf(node);
 
                        this.printTreeLevel2();
 
 
                    } else if (isRed(other.rightChild) && isBlack(other.leftChild)) {
 
                        System.out.println("other��ǰ���Һ����Ǻ�ɫ��other�������Ǻ�ɫ");
                        System.out.println("����balanceDeletion��while�����2-R-c:�ֵܵ��Һ����Ǻ�ɫ�������Ǻ�ɫ��----parent��죬other���Һ��ӱ�ڣ�Ȼ��other������");
 
                        setRed(parent);
                        setBlack(other.rightChild);
                        leftRonate(other);
 
                        this.printTreeLevel2();
 
 
                    } else if (isRed(other.leftChild)) {
 
                        System.out.println("other�������Ǻ�ɫ");
                        System.out.println("����balanceDeletion��while�����2-R-d:�ֵܵ������Ǻ�ɫ��----���׵���ɫ��ֵ��other,����Ⱦ�ڣ�other������Ⱦ�ڣ���������������whileѭ��");
 
                        setColor(other, colorOf(parent));
                        setBlack(parent);
                        setBlack(other.leftChild);
                        rightRonate(parent);
 
                        this.printTreeLevel2();
 
                        break;
 
                    }
 
                }
 
            }
 
        }
 
        //�����node��ʵ�Ǽ������뱻ɾλ�õ�����ڵ�
        //����node�Ǻ�ɫ����ͬʱ��ɾ�ڵ��Ǻ�ɫ��
        // ��˵����ֱ�Ӱ�node����ɫ�ɺ��ڣ���ֱ�������ˣ�����Ҫ���κ���ת
        if (node != null){
            System.out.println("�ڵ㣺" + node.key + "Ⱦ��");
        }
        setBlack(node);
 
        this.printTreeLevel2();
 
        System.out.println("������ɣ�������������");
 
    }
 
 
    //�������Ӳ���
    public void insertNode(T key, D data) {
 
        int com;
        RBNode<T, D> x = this.root;
        RBNode<T, D> y = null;
 
        //������̺Ͷ���������Ĺ�����һ���ģ�����ѭ�����ף�ֱ���ҵ�Ϊֹ
        while (x != null) {
            y = x;
            com = key.compareTo(x.key);
 
            if(com == 0){
                //˵����ȣ��ҵ��ˣ�ֱ���滻��ֵ������
                //TODO
 
                return ;
            }
 
            if (com < 0) {
                x = x.leftChild;
            } else {
                x = x.rightChild;
            }
        }
 
        //����һ���µĽڵ�
        RBNode<T, D> node = new RBNode<T, D>(BLACK, key, data, null, null, null);
        //ͨ������ıȽϣ��Ѿ��ҵ��˸���
        node.parent = y;
 
        if (y != null) {
            //�ٴ����Ƚϣ�����Ҫ���½ڵ���ڸ��׵���һ��
            com = node.key.compareTo(y.key);
            if (com < 0) {
                y.leftChild = node;
            } else {
                y.rightChild = node;
            }
        } else {
            //�����ҵ��ĸ���Ϊ�գ���˵���϶�֮ǰ��û�и����ǿ���
            //������½ڵ���Ϊ��
            this.root = node;
 
        }
        //���ݺ���������ʣ���Ĭ�Ͻڵ�����Ϊ��ɫ�����ϻ��ݣ��������оٿ��ܳ��ֵ������
        // ���������½ڵ㶼Ĭ�����óɺ�ɫ
        setRed(node);
 
        //���������������ؼ��ķ��� ����������ƽ����̣������������ֺ����������
        balanceInsertion(node);
 
    }
 
    public void insert(T key, D data) {
        insertNode(key, data);
    }
 
    public void add(T key, D data) {
        insertNode(key, data);
    }
 
 
    /**
     * �����ɾ������
     *
     * @param node  ������Ǵ�ɾ���ڵ�
     */
    public void delete(RBNode<T, D> node) {
 
        RBNode<T, D> child, parent, replace;
        Boolean color = true;
 
        //ɾ����������Ҳ�����������Ȼ�������������ϸ��
 
        //�����ɾ���ڵ��˫�ڵ㶼��Ϊ�գ���������ϸ���
        if (node.leftChild != null && node.rightChild != null) {
 
            //�ҵ����滻�ڵ㣬����Ҫ�����ɾ�ڵ�ָ����½ڵ�
            replace = successor(node);
            //�ҵ��滻�ڵ�ĸ��׽ڵ�
            parent = parentOf(replace);
            //��Ϊ�滻�ڵ��Ѿ����������е���Сֵ�ˣ�����ֻ���Һ���
            child = replace.rightChild;
 
            //������ΪʲôҪ��ȡ�滻�ڵ����ɫ�أ�
            //���������룬��Ϊ�滻�ڵ��ָ�����տ϶��ǻᶪʧ�ģ���Ϊ�滻�ڵ㼴�����ܴ�ɾ�ڵ��ָ�룬�����滻�ڵ��ָ��Ͳ��ٱ�����
            //��Ȼ���ٱ�������˵��ԭ���滻�ڵ�����϶�������һ��������һ���ڵ㣬������������ж�����ɫ�ı�Ҫ
            //�����ٵ�ǡǡ�Ǻ�ɫ����˵������Ӱ����������ƽ���ԣ�����������������
            color = colorOf(replace);
 
            if (node == parentOf(replace)) {
                //�����滻�ڵ�ĸ��׽ڵ���ǵ�ǰ��ɾ���ڵ�
                //�Ǿ�ֱ�ӰѴ�ɾ���ڵ��ָ�븳ֵ��parent
                parent = replace;
 
            } else {
                //�����滻�ڵ�ĸ��ײ��Ǵ�ɾ���ڵ�ĸ���
                if (child != null) {
                    //��Ϊ�滻�ڵ������Ҫ��ɾ���ģ���Ϊ����ֵ�ᱻ���õ���ɾ���ڵ��У�Ȼ����滻�ڵ�ɾ�����൱���������ɾ������
                    //����ҪΪ�滻�ڵ�ĺ��ӽڵ��ҵ��¸���
                    setParent(child, parentOf(replace));
                }
                //Ȼ���滻�ڵ���Һ������ó��滻�ڵ�ĸ��׵�����
                replace.parent.leftChild = child;
                replace.rightChild = node.rightChild;
                setParent(node.rightChild, replace);
            }
 
            //��Ŀ��ɾ���ڵ�node�ĸ������ó��滻�ڵ�ĸ���
            setParent(replace, parentOf(node));
            replace.leftChild = node.leftChild;
            setParent(node.leftChild, replace);
            //����ָ��ĵ�������ɫҲҪ���ǣ��滻�ڵ��Ȼ�����˴�ɾ�ڵ��λ�ã���ô��ɫҲҪ����֮ǰ����ɫ��������������������������
            setColor(replace, colorOf(node));
 
            if (parentOf(node) != null) {
                //��ɾ�ڵ�ĸ��׽ڵ���粻Ϊ�գ��Ǿ�Ҫ�������׽ڵ�����Һ���ָ��
                if (node.parent.leftChild == node) {
                    node.parent.leftChild = replace;
                } else {
                    node.parent.rightChild = replace;
                }
 
            } else {
                this.root = replace;
            }
            //�����������̾�����replace��ָ����ȫȡ����node�ڵ㣬����Ϊֹ��node�ڵ����һ�������ڵ��ˣ�������ɾ����
 
            if (color == BLACK) {
                balanceDeletion(child, parent);
            }
 
        } else {
 
            //�����ɾ�ڵ�ֻ������������������
            if (node.leftChild != null) {
                replace = node.leftChild;
            } else {
                replace = node.rightChild;
            }
            //�ҵ���ɾ�ڵ�ĸ��׽ڵ�
            parent = parentOf(node);
 
            if (parent != null) {
                //�жϴ�ɾ�ڵ����ڸ��׵�������
                if (parent.leftChild == node) {
                    parent.leftChild = replace;
                } else {
                    parent.rightChild = replace;
                }
            } else {
                //�����ɾ�ڵ�ĸ���Ϊ�գ���˵����ԭ�����Ǹ�
                //����ɾ�ˣ����Ժ�����Ϊ��
                this.root = replace;
            }
 
            //��parent���ó�replace�ĸ���
            setParent(replace, parent);
 
            color = colorOf(node);
            child = replace;
            //�����ɾ�ڵ��Ǻ�ɫ�ڵ㣬��˵������ɾ���϶���Ӱ������������
            //ɾ��ɫ�ڵ㣬��Ҫ����ƽ�⣬��֮��ɾ����ɫ�ڵ㣬����Ҫ����
            if (color == BLACK) {
                balanceDeletion(child, parent);
            }
 
        }
 
 
    }
 
    public void delete(T key) {
        RBNode<T, D> node;
        if ((node = search(key, this.root)) != null) {
            delete(node);
        }
 
    }
 
    public void remove(T key) {
        RBNode<T, D> node;
        if ((node = search(key, this.root)) != null) {
            delete(node);
        }
 
    }
 
    //ǰ�����
    public void preOrder(RBNode<T, D> node) {
        if (node != null) {
 
            System.out.print(node.key + " ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
 
        }
 
 
    }
 
    public void preOrder() {
        preOrder(this.root);
 
    }
 
    //�������
    public void inOrder(RBNode<T, D> node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.print(node.key + " ");
            inOrder(node.rightChild);
 
        }
 
    }
 
    public void inOrder() {
        inOrder(this.root);
 
    }
 
    //�������
    public void postOrder(RBNode<T, D> node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.print(node.key + " ");
 
        }
 
    }
 
    public void postOrder() {
        postOrder(this.root);
 
    }
 
    /**
     * ��ӡ���������Ĳ㼶�ṹ��Ϊ�˷��������ת�Ĺ���
     *
     */
    public void printTreeLevel(){
 
        System.out.println("��ʼ������Ĳ㼶�ṹ");
        ConcurrentHashMap<Integer, List<RBNode>> map = showTree();
        int size = map.size();
 
        for (int i = 0; i < map.size(); i++) {
            System.out.println();
            for (int j = 0; j < map.get(i).size(); j++) {
                System.out.print( makeSpace2(size, i) +
                        (map.get(i).get(j).key == null ? " " : (map.get(i).get(j).key) + (map.get(i).get(j).color? "(��)":"(��)")) + makeSpace2(size, i));
 
            }
            System.out.println();
        }
        System.out.println("����������Ĳ㼶�ṹ");
 
    }
 
    public void printTreeLevel2(){
 
        System.out.println("��ʼ�������Graphviz�ṹ");
        ConcurrentHashMap<Integer, List<RBNode>> map = showTree();
        int size = map.size();
        System.out.println("digraph kunghsu{");
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
 
                if(map.get(i).get(j).key != null){
                    System.out.println(map.get(i).get(j).key + " [color="  + (map.get(i).get(j).color == RED?"red":"black")  + " style=filled fontcolor=white] ");
                }
            }
        }
 
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                String content = "";
 
                if(map.get(i).get(j).key != null){
                    if(map.get(i).get(j).leftChild != null){
                        System.out.println(map.get(i).get(j).key + "->" + map.get(i).get(j).leftChild.key + "[label=left]");
                    }
                    if(map.get(i).get(j).rightChild != null){
                        System.out.println(map.get(i).get(j).key + "->" + map.get(i).get(j).rightChild.key + "[label=right]");
                    }
                }
            }
        }
        System.out.println("}");
 
        System.out.println("�����������Graphviz�ṹ");
 
    }
 
    /**
     * Ϊ����������нṹ�У���Ԫ��ǰƴ��һЩ�ո񣬶���
     *
     * @param size
     * @param index
     * @return
     */
    public String makeSpace2(int size, int index){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1 << (size - index); i++) {
            builder.append("  ");
        }
        return builder.toString();
    }
 
    public ConcurrentHashMap<Integer, List<RBNode>> showTree(){
 
        ConcurrentHashMap<Integer, List<RBNode>> map = new ConcurrentHashMap<>();
        showTree(root, 0, map);
        return  map;
    }
 
    public void showTree(RBNode root, int count, ConcurrentHashMap<Integer, List<RBNode>> map){
 
        if(map.get(count) == null){
            map.put(count, new ArrayList<>());
        }
        map.get(count).add(root);
 
        if(root.leftChild != null){
            showTree(root.leftChild, count+1 , map);
        }else{
            //����Ϊ�գ�Ҳ��ӵ�map�У���Ϊ��Ҫ����ʽ�����ƣ��յģ���ҲҪ֪�������λ���ǿյ�
            if(map.get(count+1) == null){
                map.put(count+1, new ArrayList<>());
            }
            map.get(count+1).add(new RBNode(false, null, null, null, null, null));
        }
        if(root.rightChild != null){
            showTree(root.rightChild, count+1 , map);
        }else{
            if(map.get(count+1) == null){
                map.put(count+1, new ArrayList<>());
            }
            map.get(count+1).add(new RBNode(false, null, null, null, null, null));
        }
    }
}

