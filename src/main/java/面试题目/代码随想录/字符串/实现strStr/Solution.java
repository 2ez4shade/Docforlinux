package 面试题目.代码随想录.字符串.实现strStr;

import java.util.Arrays;

/**
 * @author: shade
 * @date: 2022/5/2 16:07
 * @description:
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = kmp(needle);
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public int[] kmp(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < next.length; i++) {
            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == needle.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "mississippi";
        String s2 = "issip";
        System.out.println(Arrays.toString(s.kmp(s2)));
    }
}