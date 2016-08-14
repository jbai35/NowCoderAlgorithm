package com.algo.order;

//����һ��int���飬���дһ�����������㷨��������Ԫ������
//����һ��int����A������Ĵ�Сn���뷵�����������顣
//����������
//[1,2,3,5,2,3],6
//[1,2,2,3,3,5]

public class QuickSort {
	public static int[] quickSort(int[] A, int n) {
		// write code here
		sort(A, 0, n - 1);
		return A;
	}

	private static void sort(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			int partion = partion(a, left, right);
			sort(a, left, partion - 1);
			sort(a, partion + 1, right);
		}
	}

	private static int partion(int[] a, int left, int right) {
		// TODO Auto-generated method stub
		int partion = 0;
		int flag = a[left];
		int i = left;
		int j = right;
		if (left < right) {
			while (i < j) {
				while (i < j && flag <= a[j])
					j--;
				if (i < j)
					a[i] = a[j];
				while (i < j && a[i] <= flag)
					i++;
				if (i < j)
					a[j] = a[i];
			}
			a[i] = flag;
		}
		partion = i;
		return partion;
	}

	public static void main(String[] args) {
		int[] a = { 54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28 };
		int[] result = quickSort(a, 13);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}