package 面试题目.代码随想录.哈希表.赎金信;

/**
 * @author: shade
 * @date: 2022/5/1 11:21
 * @description:
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ints = new int[26];
        for (char c : magazine.toCharArray()) {
            ints[c - 'a'] ++;
        }
        for (char c : ransomNote.toCharArray()) {
            ints[c - 'a'] --;
            if (ints[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}