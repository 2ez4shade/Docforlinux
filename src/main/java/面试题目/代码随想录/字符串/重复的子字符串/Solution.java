package 面试题目.代码随想录.字符串.重复的子字符串;

/**
 * @author: shade
 * @date: 2022/5/2 16:50
 * @description:
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if (len == 0) {
            return false;
        }
        int[] next = new int[len];
        next[0] = 0;
        for (int i = 1, j = 0; i < len; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }

        if (next[len-1]!=0&&(len%(len-next[len-1])==0)){
            return true;
        }
        return false;
    }
}