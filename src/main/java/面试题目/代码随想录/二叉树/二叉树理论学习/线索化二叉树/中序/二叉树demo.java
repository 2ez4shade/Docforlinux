package 面试题目.代码随想录.二叉树.二叉树理论学习.线索化二叉树.中序;

/**
 * @author: shade
 * @date: 2022/5/8 15:07
 * @description:
 */
public class 二叉树demo {
    public static void main(String[] args) {
        Node ame = new Node(1, "ame");
        Node maybe = new Node(2, "maybe");
        Node chalice = new Node(3, "chalice");
        Node fy = new Node(4, "fy");
        Node xnove = new Node(5, "xnove");

        BinaryTree tree = new BinaryTree(ame);
        ame.setLeft(maybe);
        ame.setRight(chalice);
        chalice.setLeft(fy);
        chalice.setRight(xnove);
        tree.threadedNodes(ame);
        System.out.println(maybe.getRight());
        System.out.println("============");
        tree.threadedList();
    }
}

class BinaryTree {
    Node root;
    Node pre;

    public BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * 中序线索化
     */
    public void threadedNodes(Node node) {
        if (node == null) {
            return;
        }
        //线索化左边
        threadedNodes(node.getLeft());

        //线索化自己
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftnode(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightnode(1);
        }
        //per变化
        pre = node;
        //线索化右边
        threadedNodes(node.getRight());
    }

    public void threadedList() {
        Node node = root;
        while (node != null){

            while (node.getLeftnode()==0){
                node=node.getLeft();
            }

            System.out.println(node);

            while (node.getRightnode()==1){
                node = node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }
    }

}

class Node {
    private int id;
    private String name;
    private Node left;
    private Node right;
    //左边不是null为0 是null为1
    private int leftnode;

    public int getLeftnode() {
        return leftnode;
    }

    public void setLeftnode(int leftnode) {
        this.leftnode = leftnode;
    }

    public int getRightnode() {
        return rightnode;
    }

    public void setRightnode(int rightnode) {
        this.rightnode = rightnode;
    }

    //右边不是null为0 是null为1
    private int rightnode;

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}