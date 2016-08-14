package com.algo.order;

//对于一个int数组，请编写一个选择排序算法，对数组元素排序。
//给定一个int数组A及数组的大小n，请返回排序后的数组。
//测试样例：
//[1,2,3,5,2,3],6
//[1,2,2,3,3,5]

public class BubbleSort {
	public static int[] bubbleSort(int[] A, int n) {
		// write code here
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (A[j] > A[j + 1]) {
					swap(A, j, j + 1);
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
		int[] a = { 1, 2, 3, 5, 2, 3 };
		int[] result = bubbleSort(a, 6);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}