package 面试题目.代码随想录.字符串.翻转字符串里的单词;

/**
 * 直接使用库函数
 * @author: shade
 * @date: 2022/5/2 11:55
 * @description:
 */
public class Solution2 {
    public String reverseWords(String s) {
        String trim = s.trim();
        String s1 = trim.replaceAll(" +", " ");
        String[] s2 = s1.split(" ");
        for (int start = 0, end = s2.length - 1; start < end; start++, end--) {
            String temp = s2[start];
            s2[start] = s2[end];
            s2[end] = temp;
        }
        String rse = "";
        for (int i = 0; i < s2.length; i++) {
            if (i == 0) {
                rse += s2[i];
            }else {
                rse += (" " + s2[i]);
            }
        }
        return rse;
    }


}
