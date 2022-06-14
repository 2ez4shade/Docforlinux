package 面试题目.代码随想录.哈希表.四树之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: shade
 * @date: 2022/5/1 12:11
 * @description:
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int newtarget;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            newtarget = target - nums[i];

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    int sum = nums[j] + nums[left] + nums[right];
                    if (sum > newtarget) {
                        right--;
                    } else if (sum < newtarget) {
                        left++;
                    } else {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return lists;
    }
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        for(;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
