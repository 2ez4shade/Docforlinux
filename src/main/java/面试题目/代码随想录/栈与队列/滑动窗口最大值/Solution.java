package 面试题目.代码随想录.栈与队列.滑动窗口最大值;

import java.util.*;

/**
 * @author: shade
 * @date: 2022/5/5 13:46
 * @description:
 */
public class Solution {
    /**
     * 暴力解法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int fast = k - 1;
        int slow = 0;
        int[] res = new int[nums.length - k + 1];
        for (; fast < nums.length; fast++, slow++) {
            int num = Integer.MIN_VALUE;
            for (int i = slow; i <= fast; i++) {
                num = Math.max(num, nums[i]);
            }
            res[slow] = num;
        }
        return res;
    }

    /**
     * 好解法 先自定义一个队列对Deque进行包装 改变添加 和 poll的方法
     */
    class MyQueue {
        Deque<Integer> queue = new LinkedList<>();

        void poll(int i) {
            if (!queue.isEmpty() && queue.peek() == i) {
                queue.poll();
            }
        }

        void add(int i) {
            while (!queue.isEmpty() && i > queue.getLast()) {
                queue.removeLast();
            }
            queue.add(i);
        }
        int  peek(){
           return queue.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==1){
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[0]=myQueue.peek();

        for(int i=0;i<nums.length-k;){
            myQueue.poll(nums[i]);
            myQueue.add(nums[i+k]);
            i++;
            res[i] = myQueue.peek();
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution solution = new Solution();
        solution.maxSlidingWindow(a,3);
    }
    /**
     * 另一种做法
     */
    public int[] maxSlidingWindow22(int[] nums, int k){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int num = 0;
        int[] res = new int[nums.length - k + 1];
        for (int i=0;i<nums.length;i++){
            while (!deque.isEmpty()&&deque.peek()<i-k+1){
                deque.poll();
            }
            while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offer(i);

            if (i>=k-1){
                res[num++]=nums[deque.peek()];
            }
        }
        return res;

    }


}