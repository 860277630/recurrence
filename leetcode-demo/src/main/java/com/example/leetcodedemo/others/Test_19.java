package com.example.leetcodedemo.others;

/**
 * 固定开销下最长子串
 * 给两个长度相同的字符串 s、t，把 s[i] 修改成 t[i] 的开销为：
 *
 * cost = |s[i] - t[i]|
 *
 * 例如：
 *
 * a → b = 1
 * a → c = 2
 * c → a = 2
 *
 * 给定最大开销 maxCost，求在总开销不超过 maxCost 的情况下，可以修改的最长连续子串长度。
 *
 * 例如：
 *
 * s = "abcd"
 * t = "bcdf"
 * maxCost = 3
 *
 * 每个位置开销：
 *
 * a → b = 1
 * b → c = 1
 * c → d = 1
 * d → f = 2
 *
 * cost = [1, 1, 1, 2]
 */
public class Test_19 {
    public static void main(String[] args) {

        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;

        System.out.println(equalSubstring(s, t, maxCost)); // 3
    }

    public static int equalSubstring(String s, String t, int maxCost) {

        int left = 0;
        int cost = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // 加入当前字符的修改开销
            cost += Math.abs(s.charAt(right) - t.charAt(right));

            // 超过最大开销，缩小窗口
            while (cost > maxCost) {

                cost -= Math.abs(
                        s.charAt(left) - t.charAt(left)
                );

                left++;
            }

            // 当前窗口一定满足 cost <= maxCost
            maxLength = Math.max(
                    maxLength,
                    right - left + 1
            );
        }

        return maxLength;
    }
}
