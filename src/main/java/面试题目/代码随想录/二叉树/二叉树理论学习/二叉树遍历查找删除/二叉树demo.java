package 面试题目.代码随想录.二叉树.二叉树理论学习.二叉树遍历查找删除;

/**
 * @author: shade
 * @date: 2022/5/8 15:07
 * @description:
 */
public class 二叉树demo {
    public static void main(String[] args) {
        Node ame = new Node(1, "ame");
        Node maybe = new Node(2, "maybe");
        Node xdd = new Node(3, "xdd");
        Node kaka = new Node(4, "kaka");
        Node jt = new Node(5, "jt");
        BinaryTree tree = new BinaryTree(ame);
        ame.setLeft(maybe);
        ame.setRight(xdd);
        xdd.setLeft(kaka);
        xdd.setRight(jt);
//        tree.perOrder();
//        System.out.println("=======================");
//        tree.midOrder();
//        System.out.println("=======================");
//        tree.nextOrder();
//        System.out.println("==========前序查找============");
//        System.out.println(tree.perOrderSearch(1));
//        System.out.println("==========中序查找============");
//        System.out.println(tree.midOrderSearch(1));
//        System.out.println("==========后序查找============");
//        System.out.println(tree.nextOrderSearch(1));
        tree.perOrder();
        tree.deleteNode(3);
        System.out.println("============");
        tree.perOrder();
    }
}

class BinaryTree {
    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void perOrder() {
        if (root != null) {
            root.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (root != null) {
            root.midOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void nextOrder() {
        if (root != null) {
            root.nextOrder();
        }
    }

    /**
     * 前序查找
     */
    public Node perOrderSearch(int id) {
        if (root == null) {
            return null;
        } else {
            return root.perOrderSearch(id);
        }
    }

    /**
     * 中序查找
     */
    public Node midOrderSearch(int id) {
        if (root == null) {
            return null;
        } else {
            return root.midOrderSearch(id);
        }
    }

    /**
     * 后序查找
     */
    public Node nextOrderSearch(int id) {
        if (root == null) {
            return null;
        } else {
            return root.nextOrderSearch(id);
        }
    }
    /**
     * 删除结点
     */
    public void deleteNode(int id){
        if (root==null||root.getId()==id){
            root=null;
            return;
        }
        root.deleteNode(id);
    }
}

class Node {
    private int id;
    private String name;
    private Node left;
    private Node right;

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

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.getLeft().preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void nextOrder() {
        if (this.left != null) {
            this.left.nextOrder();
        }
        if (this.right != null) {
            this.right.nextOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序查找
     */
    public Node perOrderSearch(int id) {
        System.out.println("进入前序");
        if (this.id == id) {
            return this;
        }
        Node node = null;
        if (this.left != null) {
            node = this.left.perOrderSearch(id);
        }
        if (node != null) {
            return node;
        }
        if (this.right != null) {
            node = this.right.perOrderSearch(id);
        }
        return node;
    }

    /**
     * 中序查找
     */
    public Node midOrderSearch(int id) {
        System.out.println("进入中序");
        Node node = null;
        if (this.left != null) {
            node = this.left.midOrderSearch(id);
        }
        if (node != null) {
            return node;
        }
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            node = this.right.midOrderSearch(id);
        }
        return node;
    }

    /**
     * 后序遍历
     */
    public Node nextOrderSearch(int id) {
        System.out.println("进入后序");
        Node node = null;
        if (this.left != null) {
            node = this.left.nextOrderSearch(id);
        }
        if (node != null) {
            return node;
        }
        if (this.right != null) {
            node = this.right.nextOrderSearch(id);
        }
        if (node != null) {
            return node;
        }
        if (this.id == id) {
            return this;
        }
        return null;
    }
    /**
     * 删除节点
     */
    public void deleteNode(int id){
        if (this.left!=null&&this.left.id==id) {
            this.left=null;
            return;
        }
        if (this.right!=null&&this.right.id==id) {
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.deleteNode(id);
        }
        if (this.right!=null){
            this.right.deleteNode(id);
        }
    }
}