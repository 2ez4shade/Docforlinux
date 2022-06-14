package 面试题目.代码随想录.二叉树.二叉树理论学习.顺序存储二叉树;

/**
 * @author: shade
 * @date: 2022/5/8 23:19
 * @description:
 */
public class ArrBinaryTree_Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.perOrder();
        System.out.println("===============");
        tree.midOrder();
        System.out.println("================");
        tree.nextOrder();
    }
}

class ArrBinaryTree {
    int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 重载一下遍历
     */
    public void perOrder() {
        perOrder(0);
    }
    public void midOrder() {
        midOrder(0);
    }
    public void nextOrder() {
        nextOrder(0);
    }

    /**
     * 前序遍历
     */
    public void perOrder(int index) {
        if (arr == null || arr.length == 0) {
            return;
        }
        System.out.println(arr[index]);
        if (2 * index + 1 < arr.length) {
            perOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            perOrder(2 * index + 2);
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder(int index) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (2*index+1<arr.length){
            midOrder(2*index+1);
        }
        System.out.println(arr[index]);
        if (2*index+2<arr.length){
            midOrder(2*index+2);
        }
    }

    /**
     * 后序遍历
     */
    public void nextOrder(int index){
        if(arr==null||arr.length==0){
            return;
        }
        if (2*index+1<arr.length){
            nextOrder(2*index+1);
        }
        if (2*index+2<arr.length){
            nextOrder(2*index+2);
        }
        System.out.println(arr[index]);
    }
}
