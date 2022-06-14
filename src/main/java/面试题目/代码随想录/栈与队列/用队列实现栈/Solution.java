package 面试题目.代码随想录.栈与队列.用队列实现栈;

import java.util.*;

/**
 * @author: shade
 * @date: 2022/5/5 10:24
 * @description:
 */
public class Solution {
}

/**
 * 用2个ArrayList模拟栈
 */
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        copy();
        Integer poll = queue1.poll();
        huitui();
        return poll;
    }

    public int top() {
        copy();
        Integer peek = queue1.peek();
        queue2.add(queue1.poll());
        huitui();
        return peek;
    }

    public boolean empty() {
        return queue1.size()==0;
    }
    private void copy(){
        if(queue1.size()==0||queue1.size()==1){
            return;
        }
        while (queue1.size()!=1){
            queue2.add(queue1.poll());
        }
    }
    private void huitui(){
        while (queue2.size()!=0){
            queue1.add(queue2.poll());
        }
    }
}

/**
 * 第二种方式
 */
class MyStack2 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack2() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp=queue1;
        queue1=queue2;
        queue2=temp;
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
class MyStack3 {
    Deque<Integer> deque;
    public MyStack3() {
        deque = new ArrayDeque<>();
    }

    public void push(int x) {
        deque.add(x);
        for (int i = 0; i < deque.size()-1; i++) {
            deque.addLast(deque.pollFirst());
        }
    }

    public int pop() {
        return deque.pollFirst();
    }

    public int top() {
        return deque.peekFirst();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}