package com.algo.string;

//�������ñ˴˶����Ķ�����A��B�����дһ����Ч�㷨�����A���Ƿ����һ��������B�������˽ṹ��ȫ��ͬ��

//�������ö�������ͷ���A��B���뷵��һ��boolֵ������A���Ƿ����һ��ͬ����B��������

//KMP + �����������л�

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class IdenticalTree {
	public boolean chkIdentical(TreeNode A, TreeNode B) {
		// write code here
		String treeA = serial(A);
		String treeB = serial(B);
		return getIndex(treeA, treeB) != -1;
	}

	private int getIndex(String s, String m) {
		// TODO Auto-generated method stub
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int[] next = new int[ms.length];
		next = getNext(ms);
		int si, mi;
		for (si = 0, mi = 0; si < ss.length; ++si) {
			while (mi > 0 && ss[si] != ms[mi]) {
				mi = next[mi - 1];
			}
			if (ss[si] == ms[mi]) {
				mi++;
			}
			if (mi == ms.length) {
				return si - ms.length + 1;
			}
		}
		return -1;
	}

	private int[] getNext(char[] ms) {
		// TODO Auto-generated method stub
		int[] next = new int[ms.length];
		next[0] = 0;
		for (int i = 1, j = 0; i < ms.length; ++i) {
			while (j > 0 && ms[i] != ms[j]) {
				j = next[j - 1];
			}
			if (ms[i] == ms[j]) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}

	private String serial(TreeNode a) {
		// TODO Auto-generated method stub
		if (a == null) {
			return "#!";
		}
		StringBuilder sBuilder = new StringBuilder(a.val + "!");
		sBuilder.append(serial(a.left));
		sBuilder.append(serial(a.right));
		return sBuilder.toString();
	}
}