package com.algo.order;

//对于一个int数组，请编写一个归并排序算法，对数组元素排序。
//给定一个int数组A及数组的大小n，请返回排序后的数组。
//测试样例：
//[1,2,3,5,2,3],6
//[1,2,2,3,3,5]

public class MergeSort {
	public static int[] mergeSort(int[] A, int n) {
		// write code here
		sort(A, 0, n - 1);
		return A;
	}

	public static void sort(int[] arr, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			sort(arr, left, middle);
			sort(arr, middle + 1, right);
			merge(arr, left, middle, right);
		}
	}

	public static void merge(int[] arr, int left, int middle, int right) {
		int i = left;
		int j = middle + 1;
		int k = i;
		int[] temp = new int[arr.length];
		while (i <= middle && j <= right) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		// 剩余未合并的部分
		while (i <= middle) {
			temp[k++] = arr[i++];
		}
		while (j <= right) {
			temp[k++] = arr[j++];

		}
		// 将临时数组中的内容存储到原数组中
		while (left <= right) {
			arr[left] = temp[left++];
		}
	}

	public static void main(String[] args) {
		int[] a = { 54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28 };
		int[] result = mergeSort(a, 13);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
