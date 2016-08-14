package com.algo.order;

//对于一个int数组，请编写一个希尔排序算法，对数组元素排序。
//给定一个int数组A及数组的大小n，请返回排序后的数组。保证元素小于等于2000。
//测试样例：
//[1,2,3,5,2,3],6
//[1,2,2,3,3,5]

public class ShellSort {
	public static int[] shellSort(int[] A, int n) {
		// write code here
		if (A == null || n < 2)
			return A;
		int feet = n / 2;
		int index = 0;
		while (feet > 0) {
			for (int i = feet; i < n; i++) {
				index = i;
				while (index >= feet) {
					if (A[index] < A[index - feet]) {
						swap(A, index, index - feet);
						index -= feet;
					} else {
						break;
					}

				}
			}
			feet /= 2;
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
		int[] result = shellSort(a, 6);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
