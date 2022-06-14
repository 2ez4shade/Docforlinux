package 面试题目.代码随想录.栈与队列.有效的括号;

import java.util.Stack;

/**
 * @author: shade
 * @date: 2022/5/5 11:54
 * @description:
 */
public class Solution {
    /**
     * shade的解法 有点冗余但还行
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (char aChar : chars) {
            if (stack.isEmpty()) {
                stack.push(aChar);
            } else if (aChar == '{' || aChar == '[' || aChar == '(') {
                stack.push(aChar);
            } else if (aChar == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(aChar);
                }
            } else if (aChar == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(aChar);
                }
            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(aChar);
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid2(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar=='('){
                stack.push(')');
            }else if (aChar=='['){
                stack.push(']');
            }else if (aChar=='{'){
                stack.push('}');
            }else if (stack.isEmpty()||stack.peek()!=aChar){
                return false;
            }else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
    }
}