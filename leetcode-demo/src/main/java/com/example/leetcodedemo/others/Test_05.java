package com.example.leetcodedemo.others;

import java.util.*;

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

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 出现重复字符，移动 left
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // 当前字符加入窗口
            set.add(c);

            // 更新最大窗口
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
