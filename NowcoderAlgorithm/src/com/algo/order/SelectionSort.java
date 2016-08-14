package com.algo.order;

//����һ��int���飬���дһ��ѡ�������㷨��������Ԫ������
//����һ��int����A������Ĵ�Сn���뷵�����������顣
//����������
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
