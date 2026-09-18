package com.example.leetcodedemo.others_pratice.others;

/**
 * 【软件认证】比特翻转
 *
 * 工程师小A在对二进制码流 bits 进行验证，验证方法为：给定目标值 target（0 或 1），最多可以反转二进制码流 bits 中的一位，来获取最大连续 target 的个数，请返回该个数。
 *
 * 输入
 * 第一个参数为 target，值仅为 0 或 1；
 * 第二个参数为 bits， 1 <= bits.length <= 10000，bits[i] 值仅为 0 或 1 。
 *
 * 输出
 * 一个整数，表示最大连续 target 的个数
 *
 * 样例1
 * 复制输入：
 * 1
 * [0, 1, 1, 0, 1, 0, 1, 0, 0]
 * 复制输出：
 * 4
 * 解释：
 * 0 1 1 0 1 0 1 0 0
 * 目标值为1，表示需要获取最大连续1的个数。
 * 将第二个出现的0反转为1，得到0 1 1 1 1 0 1 0 0 ，获得 4 个连续的1；
 * 其它反转获得连续1的个数最大为3，如 1 1 1 0 1 0 1 0 0 或 0 1 1 0 1 1 1 0 0 。
 */
public class Test_04 {
    public static void main(String[] args) {
        int target = 1;

        int[] bits = {
                0, 1, 1, 0, 1, 0, 1, 0, 0
        };

    }

}
