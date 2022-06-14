package 面试题目.代码随想录.数组;

/**
 * @author: shade
 * @date: 2022/4/29 20:01
 * @description:
 */
public class 二分查找 {
    /**
     * 左闭右闭写法
     *
     * @param a
     * @param target
     * @return -1 就是没找到
     */
    public static int find(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while (right >= left) {
            int mid = (left + right) / 2;
            if (target > a[mid]) {
                left = mid + 1;
            } else if (target < a[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 左开右闭写法
     *
     * @param a
     * @param target
     * @return -1没找到
     */
    public static int find2(int[] a, int target) {
        int left = 0;
        int right = a.length;
        while (right > left) {
            int mid = (left + right) / 2;
            if (a[mid] > target) {
                right = mid;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(find(a, 3));
        System.out.println(find(a, 9));
        System.out.println(find(a, -1));
        System.out.println(find2(a, 3));
        System.out.println(find2(a, 9));
        System.out.println(find2(a, -1));

    }
}
