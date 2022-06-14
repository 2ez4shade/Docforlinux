package 面试题目.代码随想录.字符串.剑指Offer05替换空格;

/**
 * @author: shade
 * @date: 2022/5/2 11:23
 * @description:
 */
public class Solution {
    /**
     * 用StringBuffer来存储扩容
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        StringBuffer buffer = new StringBuffer();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                buffer.append("%20");
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    /**
     * 双指针法更省内存
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        StringBuilder buffer = new StringBuilder();
        //记录扩容的长度
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                buffer.append("  ");
            }
        }
        if (buffer.length() == 0) {
            return s;
        }
        int fast = s.length() - 1;
        s += buffer.toString();
        int slow = s.length() - 1;
        char[] chars = s.toCharArray();
        while (fast >= 0) {
            if (chars[fast]==' '){
                chars[slow--] ='0';
                chars[slow--] ='2';
                chars[slow--] ='%';
            }else {
                chars[slow--]=chars[fast];
            }
            fast--;
        }
        return new String(chars);
    }

}
