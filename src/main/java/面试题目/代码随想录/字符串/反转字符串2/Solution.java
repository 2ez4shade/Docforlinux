package 面试题目.代码随想录.字符串.反转字符串2;

/**
 * @author: shade
 * @date: 2022/5/2 11:05
 * @description:
 */
public class Solution {
    /**
     * 双指针 注意i += (2 * k) 避免了怎加很多计数器
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += (2 * k)) {
            int start = i;
            int end = Math.min(chars.length - 1, start + k - 1);
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
