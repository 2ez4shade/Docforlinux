package 面试题目.代码随想录.字符串.翻转字符串里的单词;

/**
 * @author: shade
 * @date: 2022/5/2 11:55
 * @description:
 */
public class Solution {
    public String reverseWords(String s) {
        char[] chars = removespace(s);
        reservechars(chars, 0, chars.length - 1);
        for (int start = 0, end = 0; end < chars.length; end++) {
            if (end == chars.length - 1 || chars[end] == ' ') {
                reservechars(chars, start, end-1);
                start = end + 1;
            }
        }
        return new String(chars);
    }

    /**
     * 去除空格
     * @param s
     * @return
     */
    public char[] removespace(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        //去除前后空格
        while (chars[start] == ' ') {
            start++;
        }
        while (chars[end] == ' ') {
            end--;
        }
        //去除中间空格
        while (start <= end) {
            if (chars[start] != ' ' || builder.charAt(builder.length() - 1) != ' ') {
                builder.append(chars[start]);
            }
            start++;
        }
        return builder.toString().toCharArray();
    }

    /**
     * 反转指定开头结尾的数组
     * @param chars
     * @param start
     * @param end
     */
    public void reservechars(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }


}
