package com.algo.order;

//����һ��int���飬���дһ�����������㷨��������Ԫ������
//����һ��int����A������Ĵ�Сn���뷵�����������顣
//����������
//[1,2,3,5,2,3],6
//[1,2,2,3,3,5]

public class InsertionSort {
	public static int[] insertionSort(int[] A, int n) {
		// write code here
		for (int i = 1; i < n; i++) {
			int val = A[i];
			for (int j = i - 1; j >= 0; j--) {
				if (val < A[j]) {
					swap(A, j + 1, j);
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
		int[] result = insertionSort(a, 6);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}