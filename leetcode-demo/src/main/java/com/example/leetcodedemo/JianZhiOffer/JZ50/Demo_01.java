package com.example.leetcodedemo.JianZhiOffer.JZ50;
import java.util.*;

/**
 * @description:
 * @author: wjl
 * @date: 2026/9/20
 */

public class Demo_01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @return int整型
     */
    public int FirstNotRepeatingChar (String str) {
        // write code here
        String[] strs = str.split("");
        Map<String,Integer> map =  new HashMap<>();
        for(int i = 0;i < strs.length;i++){
            Integer num = map.get(strs[i]);
            //  如果获取到的是null
            if(num == null){num =0;}
            // 然后放入 map中
            map.put(strs[i],num++);
        }
        //  然后找到 第一个出现的
        for (int i = 0; i < strs.length; i++) {
            if(map.get(strs[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
