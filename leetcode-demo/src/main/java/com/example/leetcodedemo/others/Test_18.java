package com.example.leetcodedemo.others;

/**
 * 把元音字符提取出来反转，其他字符的位置保持不变，然后把反转后的元音填回去
 * hello
 *
 * 元音：
 * e o
 *
 * 反转：
 * o e
 *
 * 结果：
 * holle
 */
public class Test_18 {
    public static void main(String[] args) {

        String str = "hello";

        String result = reverseVowels(str);

        System.out.println(result); // holle
    }

    public static String reverseVowels(String str) {

        char[] chars = str.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            // 左边寻找元音
            while (left < right && !isVowel(chars[left])) {
                left++;
            }

            // 右边寻找元音
            while (left < right && !isVowel(chars[right])) {
                right--;
            }

            // 两个元音交换
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }

        return new String(chars);
    }

    private static boolean isVowel(char c) {

        c = Character.toLowerCase(c);

        return c == 'a'
                || c == 'e'
                || c == 'i'
                || c == 'o'
                || c == 'u';
    }
}
