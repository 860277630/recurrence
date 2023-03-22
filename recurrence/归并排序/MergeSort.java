package com.example.demo.controller;

import java.util.Arrays;

/**
 * @program: demoForWeb
 * @description: 归并排序
 * @author: wjl
 * @create: 2023-02-14 00:26
 **/
public class MergeSort {
    public static void merge(int array[], int left, int middle, int right) {
        int i, j, k, n1, n2;
        n1 = middle - left + 1;
        n2 = right - middle;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (i = 0, k = left; i < n1; i++, k++)
            L[i] = array[k];
        for (i = 0, k = middle + 1; i < n2; i++, k++)
            R[i] = array[k];
        for (k = left, i = 0, j = 0; i < n1 && j < n2; k++) {
            if (L[i] > R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
        }
        if (i < n1) {
            for (j = i; j < n1; j++, k++)
                array[k] = L[j];
        }
        if (j < n2) {
            for (i = j; i < n2; i++, k++) {
                array[k] = R[i];
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int array[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            System.out.println("前序遍历："+Arrays.toString(array));
            mergeSort(array, left, middle);
            //System.out.println("中序遍历："+Arrays.toString(array));
            mergeSort(array, middle + 1, right);
            //System.out.println("后序遍历："+Arrays.toString(array));
            merge(array, left, middle, right);
        }
    }




    public static void main(String[] args) {

        int a[] = { 5, 4, 9, 8, 7, 6, 0, 1, 2, 3 };
        mergeSort(a, 0, a.length - 1);
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
    }
}
