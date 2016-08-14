package com.algo.string;

//对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。

//给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。

//KMP + 二叉树的序列化

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