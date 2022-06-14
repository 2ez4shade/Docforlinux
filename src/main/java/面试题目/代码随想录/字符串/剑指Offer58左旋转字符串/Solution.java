package 面试题目.代码随想录.字符串.剑指Offer58左旋转字符串;

/**
 * @author: shade
 * @date: 2022/5/2 13:53
 * @description:
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        int lend = Math.min(s.length() - 1, n - 1);
        int rstart = Math.min(s.length() - 1, n );
        char[] chars = s.toCharArray();
        reversechars(chars, 0, lend);
        reversechars(chars, rstart, s.length() - 1);
        reversechars(chars, 0, s.length() - 1);
        return new String(chars);
    }

    public char[] reversechars(char[] chars, int start, int end) {
        while (start < end) {
            char temp=chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return chars;
    }
}
