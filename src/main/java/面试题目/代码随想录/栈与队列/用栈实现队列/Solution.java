package 面试题目.代码随想录.栈与队列.用栈实现队列;

import java.util.Stack;

/**
 * @author: shade
 * @date: 2022/5/5 10:02
 * @description:
 */
public class Solution {
}

class MyQueue {
    Stack<Integer> stackin;
    Stack<Integer> stackout;

    public MyQueue() {
        stackin = new Stack<>();
        stackout = new Stack<>();
    }

    public void push(int x) {
        stackin.push(x);
    }

    public int pop() {
        intoout();
        return stackout.pop();
    }

    public int peek() {
        intoout();
        return stackout.peek();
    }

    public boolean empty() {
        return stackin.isEmpty() && stackout.isEmpty();
    }

    public void intoout() {
        if (!stackout.isEmpty()) {
            return;
        }
        while (!stackin.isEmpty()) {
            stackout.push(stackin.pop());
        }
    }
}
