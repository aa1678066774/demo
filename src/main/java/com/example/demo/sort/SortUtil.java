package com.example.demo.sort;

import java.util.Arrays;

public class SortUtil {
	
	//选择排序
	public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    
    public static void main(String[] args) {
		int[] arr= {1,2,8,4,6,9,5};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
