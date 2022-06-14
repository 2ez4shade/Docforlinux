package 面试题目.代码随想录.数组;

import java.util.Arrays;

/**
 * @author: shade
 * @date: 2022/4/29 21:15
 * @description:
 */
public class 有序数组的平方 {
    /**
     * 暴力便利
     *
     * @param a
     * @return
     */
    public static int[] square(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * a[i];
        }
        Arrays.sort(a);
        return a;
    }

    /**
     * 双指针法
     * @param a
     * @return
     */
    public static int[] square2(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int[] result = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[left] * a[left] >= a[right] * a[right]) {
                result[i]=a[left] * a[left];
                left++;
            }else {
                result[i]=a[right] * a[right];
                right--;
            }
        }
       return result;
    }

    public static void main(String[] args) {
        int[] a = {-4, -1, 0, 2, 3, 5, 9};
        System.out.println(Arrays.toString(square(a)));
        int[] a2 = {-4, -1, 0, 2, 3, 5, 9};
        System.out.println(Arrays.toString(square2(a2)));
    }
}
