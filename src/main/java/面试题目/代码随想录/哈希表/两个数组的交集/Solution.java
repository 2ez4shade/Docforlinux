package 面试题目.代码随想录.哈希表.两个数组的交集;

import java.util.HashSet;

/**
 * @author: shade
 * @date: 2022/5/1 9:26
 * @description:
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums1) {
            hashSet.add(i);
        }
        HashSet<Integer> integers = new HashSet<>();
        for (int i : nums2) {
            if (hashSet.remove(i)){
                integers.add(i);
            }
        }
        int[] ints = new int[integers.size()];
        int i=0;
        for (Integer integer : integers) {
            ints[i++] = integer;
        }
        return ints;
    }
}
