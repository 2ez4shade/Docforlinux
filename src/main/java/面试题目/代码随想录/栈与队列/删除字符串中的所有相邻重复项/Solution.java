package 面试题目.代码随想录.栈与队列.删除字符串中的所有相邻重复项;

import java.util.Stack;

/**
 * @author: shade
 * @date: 2022/5/5 13:16
 * @description:
 */
public class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.isEmpty()||stack.peek()!=aChar){
                stack.push(aChar);
            }else {
                stack.pop();
            }
        }
        char[] chars1 = new char[stack.size()];
        for (int i = chars1.length-1; i >= 0; i--) {
            chars1[i] = stack.pop();
        }
        return new String(chars1);
    }

    /**
     * 更好的pop方式
     * @param s
     * @return
     */
    public String removeDuplicates2(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.isEmpty()||stack.peek()!=aChar){
                stack.push(aChar);
            }else {
                stack.pop();
            }
        }
        String res = "";
        while (!stack.isEmpty()){
            res =stack.pop()+res;
        }
        return res;
    }
}
