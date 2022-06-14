package 面试题目.代码随想录.数组;

/**
 * @author: shade
 * @date: 2022/4/29 22:10
 * @description:
 */
//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
//并返回其长度。如果不存在符合条件的子数组，返回 0。
//输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
public class 长度最小的子数组 {
    /**
     * 暴力枚举法
     *
     * @param a
     * @param b
     * @return 没找到返回0
     */
    public static int minArray(int[] a, int b) {
        //
        int result = 0X7fffffff;
        for (int i = 0; i < a.length; i++) {
            int num = 0;
            for (int j = i; j < a.length; j++) {
                num += a[j];
                if (num >= b) {
                    int temp = j - i + 1;
                    if (temp < result) {
                        result = temp;
                    }
                    break;
                }
            }
        }
        return result == 0x7fffffff ? 0 : result;
    }

    /**
     * 滑动窗口解法
     *
     * @param a
     * @param b
     * @return
     */
    public static int minArray2(int[] a, int b) {
        int result = 0x7fffffff;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            while (sum >= b) {
                int temp = i - left + 1;
                result = Math.min(result, temp);
                sum-=a[left];
                left++;
            }
        }
        return result==0x7fffffff?0:result;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 4, 3};
        System.out.println(minArray(a, 7));
        System.out.println(minArray2(a, 7));
    }
}
