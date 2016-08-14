package com.algo.order;

//对于一个int数组，请编写一个堆排序算法，对数组元素排序。
//给定一个int数组A及数组的大小n，请返回排序后的数组。
//测试样例：
//[1,2,3,5,2,3],6
//[1,2,2,3,3,5]

public class HeapSort {
	public static int[] heapSort(int[] A, int n) {
		// write code here
		for (int i = n / 2; i >= 0; i--) {
			heapAdjust(A, i, n);
		}

		for (int i = n - 1; i > 0; i--) {
			swap(A, 0, i);
			heapAdjust(A, 0, i);
		}
		return A;
	}

	private static void heapAdjust(int[] a, int index, int length) {
		// TODO Auto-generated method stub
		int temp = a[index];
		for (int j = index * 2 + 1; j < length; j = j * 2 + 1) {
			if (j < length - 1 && a[j] < a[j + 1])
				j++;
			if (temp > a[j])
				break;
			a[index] = a[j];
			index = j;
		}
		a[index] = temp;
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
		int[] result = heapSort(a, 6);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
