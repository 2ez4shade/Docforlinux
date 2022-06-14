package 面试题目.代码随想录.哈希表.四数相加;

import java.util.HashMap;
import java.util.Set;

/**
 * @author: shade
 * @date: 2022/5/1 10:53
 * @description:
 */
public class Solution {
    /**
     *把前2个和取出来sum,次数  后2个也是sum,次数
     *遍历
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map12 = new HashMap<>();
        HashMap<Integer, Integer> map34 = new HashMap<>();
        int sum;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                sum = nums1[i] + nums2[j];
                if (map12.containsKey(sum)){
                    map12.put(sum, map12.get(sum) + 1);
                }else {
                    map12.put(sum, 1);
                }
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                sum = nums3[i] + nums4[j];
                if (map34.containsKey(sum)){
                    map34.put(sum, map34.get(sum) + 1);
                }else {
                    map34.put(sum, 1);
                }
            }
        }
        int num = 0;
        Set<Integer> key12 = map12.keySet();
        Set<Integer> key34 = map34.keySet();
        for (Integer integer : key12) {
            if (key34.contains(-integer)){
                num += map12.get(integer) * map34.get(-integer);
            }
        }
        return num;
    }
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map12 = new HashMap<>();
        int sum;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                sum = nums1[i] + nums2[j];
                if (map12.containsKey(sum)){
                    map12.put(sum, map12.get(sum) + 1);
                }else {
                    map12.put(sum, 1);
                }
            }
        }
        int num = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                sum = nums3[i] + nums4[j];
                if (map12.containsKey(-sum)){
                    num += map12.get(-sum);
                }
            }
        }
        return num;
    }
}