package 面试题目.代码随想录.字符串.反转字符串;

/**
 * @author: shade
 * @date: 2022/5/2 10:59
 * @description:
 */
public class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        }
    }
}