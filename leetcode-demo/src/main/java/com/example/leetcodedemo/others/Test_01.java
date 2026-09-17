package com.example.leetcodedemo.others;

public class Test_01 {
    public static void main(String[] args) {
        System.out.println('c');
        System.out.println('a');
        System.out.println('c'-'a');
        System.out.println((char) ('a' + 1));
        String str = "vjdshfhasofhosho";
        String res = countLetters(str);
        System.out.println(res);
    }
    public static String countLetters(String str) {
        int[] counts = new int[26];

        // 1. 乱序统计
        for (char c : str.toCharArray()) {
            c = Character.toLowerCase(c);

            if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++;
            }
        }

        // 2. 固定按照 a~z 输出
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                if (sb.length() > 0) {
                    sb.append(";");
                }

                sb.append((char) ('a' + i))
                        .append("=")
                        .append(counts[i]);
            }
        }

        return sb.toString();
    }
}
