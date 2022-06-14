package 面试题目.代码随想录.哈希表.有效的字母异位词;

import java.util.HashMap;
import java.util.Set;

/**
 * @author: shade
 * @date: 2022/4/30 23:36
 * @description:
 */
public class Solution {
    /**
     * hash表解法
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c-'a']+=1;
        }
        for (char c : t.toCharArray()) {
            chars[c-'a']-=1;
        }
        for (int aChar : chars) {
            if (aChar!=0){
                return false;
            }
        }
        return true;
    }
    /**
     * 写的太冗余了 用的hashmap
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Character> keySet = map.keySet();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (keySet.contains(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        char[] charArray = t.toCharArray();
        for (char c : charArray) {
            Integer integer = map.get(c);
            if (integer == null || integer == 0) {
                return false;
            } else {
                map.put(c, integer - 1);
            }
        }
        for (Integer value : map.values()) {
            if (value!=0){
                return false;
            }
        }
        return true;
    }
}
