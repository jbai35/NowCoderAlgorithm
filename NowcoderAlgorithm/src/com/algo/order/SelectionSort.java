package com.algo.order;

//对于一个int数组，请编写一个选择排序算法，对数组元素排序。
//给定一个int数组A及数组的大小n，请返回排序后的数组。
//测试样例：
//[1,2,3,5,2,3],6
//[1,2,2,3,3,5]

public class SelectionSort {
	public static int[] selectionSort(int[] A, int n) {
		// write code here
		for (int i = 0; i < n; i++) {
			int min = A[i];
			for (int j = i + 1; j < n; j++) {
				if (A[j] < min) {
					min = A[j];
					swap(A, i, j);
				}
			}
		}
		return A;
	}

	private static void swap(int[] a, int j, int i) {
		// TODO Auto-generated method stub
		int temp = 0;
		temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28 };
		int[] result = selectionSort(a, 13);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
