package 面试题目.代码随想录.数组;

import java.util.Arrays;

/**
 * @author: shade
 * @date: 2022/4/29 20:24
 * @description:
 */
public class 移除元素 {
    /**
     * 暴力枚举发
     *
     * @param a
     * @param target
     * @return
     */
    public static int remove(int[] a, int target) {
        int size = a.length;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                for (int j = i; j < a.length - 1; j++) {
                    a[j] = a[j + 1];
                }
                size--;
                i--;
            }
        }
        return size;
    }

    /**
     * 双指针O(n)做法
     *
     * @param a
     * @param target
     * @return
     */
    public static int remove2(int[] a, int target) {
        int fastindex = 0;
        int slowindex = 0;
        for (; fastindex < a.length; fastindex++) {
            //若快指针位置的元素不等于要删除的元素
            if (a[fastindex] != target) {
                //将其挪到慢指针指向的位置，慢指针+1
                a[slowindex] = a[fastindex];
                slowindex++;

            }

        }
        //最后慢指针的大小就是新的数组的大小
        return slowindex;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 2, 2, 4, 4, 6, 7, 8};
        System.out.println(remove(a, 2));
        System.out.println(Arrays.toString(a));
        int[] a2 = {1, 2, 3, 3, 3, 2, 2, 4, 4, 6, 7, 8};
        System.out.println(remove2(a2, 2));
        System.out.println(Arrays.toString(a2));
    }
}
