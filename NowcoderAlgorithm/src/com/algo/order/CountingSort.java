package com.algo.order;

//����һ��int���飬���дһ�����������㷨��������Ԫ������
//����һ��int����A������Ĵ�Сn���뷵�����������顣
//����������
//[1,2,3,5,2,3],6
//[1,2,2,3,3,5]

public class CountingSort {
	public static int[] countingSort(int[] A, int n) {
		// write code here
		int min = A[0];
		int max = A[0];
		for (int i : A) {
			min = Math.min(i, min);
			max = Math.max(i, max);
		}
		int count[] = new int[max + 1];
		for (int i = 0; i < n; i++) {
			count[A[i]]++;
		}
		int k = 0;
		for (int i = min; i <= max; i++) {
			for (int j = 0; j < count[i]; j++) {
				A[k++] = i;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 5, 2, 3 };
		int[] result = countingSort(a, 6);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
