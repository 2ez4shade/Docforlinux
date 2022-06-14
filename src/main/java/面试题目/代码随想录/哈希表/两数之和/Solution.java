package 面试题目.代码随想录.哈希表.两数之和;

import java.util.HashMap;

/**
 * @author: shade
 * @date: 2022/5/1 10:45
 * @description:
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums==null|| nums.length<2){
            throw new RuntimeException("数据非法");
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target-nums[i])){
                int[] a = {hashMap.get(target - nums[i]), i};
                return a;
            }else {
                hashMap.put(nums[i], i);
            }
        }
        throw new RuntimeException("不存在");
    }
}
