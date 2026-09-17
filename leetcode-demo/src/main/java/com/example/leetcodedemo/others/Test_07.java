package com.example.leetcodedemo.others;

/**
 * 对于一个长度为 n字符串，我们需要对它做一些变形,
 * 首先这个字符串中包含着一些空格，就像"Helo Word"一样，然后我们要做的是把这个字符串中由空格隔开的单词反序
 * 同时反转每个字符的大小写。
 * 比如"Hello World"变形后就变成了"WORLD hELLO".
 * 数据范围:1<n< 105,字符串中包括大写英文字母、小写英文字母、空格,
 * 进阶:空间复杂度 O(n)，时间复杂度 O(n)
 * 输入描述:
 * 给定一个字符串s以及它的长度n(1≤n≤10^6)
 * 返回值描述:
 * 请返回变形后的字符串，题目保证给走的字符串均由大小写产母和空格构成.
 */
public class Test_07 {
    public static void main(String[] args) {
        String str = "Hello  World";
        String res = trans(str,str.length());
        System.out.println(res);
    }
    public static String trans(String s, int n) {

        char[] chars = s.toCharArray();

        // 1. 整体反转
        reverse(chars, 0, n - 1);

        // 2. 每个单词分别反转
        int start = 0;

        for (int i = 0; i <= n; i++) {

            // 遇到空格，或者到达字符串结尾
            if (i == n || chars[i] == ' ') {

                reverse(chars, start, i - 1);

                // 下一个单词开始位置
                start = i + 1;
            }
        }

        // 3. 大小写反转
        for (int i = 0; i < n; i++) {

            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 'a' + 'A');

            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] - 'A' + 'a');
            }
        }

        return new String(chars);
    }

    private static void reverse(char[] chars, int left, int right) {

        while (left < right) {

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
    }
}
