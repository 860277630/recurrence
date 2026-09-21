package com.example.leetcodedemo.others_pratice.others;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 给定字符串 s，找出其中不含重复字符的最长子串长度。★★★★★
 */
public class Test_05 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for(int right = 0;right<s.length();right++){
            char c = s.charAt(right);
            //  如果包含了就一直退出
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max,right - left+1);
        }

        return max;
    }
}
