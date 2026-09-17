package com.example.leetcodedemo.others;

import java.util.*;

/**
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Test_06 {
    public static void main(String[] args) {

        String[] strs = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };

        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // 1. 字符串转字符数组
            char[] chars = str.toCharArray();

            // 2. 排序
            Arrays.sort(chars);

            // 3. 排序结果作为 key
            String key = new String(chars);

            // 4. 相同 key 的字符串放到一起
            map.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(str);
        }

        return new ArrayList<>(map.values());
    }
}
