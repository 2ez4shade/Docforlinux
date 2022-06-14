package 面试题目.代码随想录.哈希表.快乐数;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author: shade
 * @date: 2022/5/1 9:56
 * @description:
 */
public class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        while (true) {
            while (n > 0) {
                int i = n % 10;
                sum = sum + i * i;
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            }
            if (hashSet.contains(sum)) {
                return false;
            } else {
                hashSet.add(sum);
            }
            n = sum;
            sum = 0;
        }
    }


    public boolean isHappy2(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (n != 1 && !hashSet.contains(n)){
            hashSet.add(n);
            n = calculation(n);
        }
        return n == 1;
    }

    private int calculation(int n) {
        int sum = 0;
        while (n != 0) {
            int i = n % 10;
            sum += i * i;
            n = n / 10;
        }
        return sum;
    }
}