package 面试题目.代码随想录.栈与队列.逆波兰表达式求值;

import java.util.Stack;

/**
 * @author: shade
 * @date: 2022/5/5 13:31
 * @description:
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stacknum = new Stack<>();
        for (String s : tokens) {
            if  ("+".equals(s)) {
                int num1 = stacknum.pop();
                int num2 = stacknum.pop();
                stacknum.push(num2 + num1);
            } else if ("-".equals(s)) {
                int num1 = stacknum.pop();
                int num2 = stacknum.pop();
                stacknum.push(num2 - num1);
            } else if ("*".equals(s)) {
                int num1 = stacknum.pop();
                int num2 = stacknum.pop();
                stacknum.push(num2 * num1);
            } else if ("/".equals(s)) {
                int num1 = stacknum.pop();
                int num2 = stacknum.pop();
                stacknum.push(num2 / num1);
            } else {
                stacknum.push(Integer.parseInt(s));
            }
        }
        return stacknum.pop();
    }
}
