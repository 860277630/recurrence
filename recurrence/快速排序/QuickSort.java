package com.example.demo.controller;


import java.util.Arrays;

/**
 * @program: demoForWeb
 * @description: 快排
 * @author: wjl
 * @create: 2023-02-14 00:47
 **/
public class QuickSort {
    public static void sort(int array[], int left, int right) {
        int i, j;
        int pivot;
        if (left >= right) {
            return;
        }
        i = left;
        j = right;
        pivot = array[i];
        while (i < j) {
            while (i < j && pivot <= array[j])
                j--;
            if (i < j)
                array[i++] = array[j];
            while (i < j && pivot > array[i])
                i++;
            if (i < j)
                array[j--] = array[i];
        }
        array[i] = pivot;
        System.out.println(Arrays.toString(array));
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }
    public static void quickSort(int array[]) {
        sort(array, 0, array.length - 1);
    }
    public static void main(String[] args) {
        int a[] = { 5, 7, 4, 8, 6, 1 };
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
