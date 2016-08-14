package com.algo.bintree;

//���õݹ鷽ʽʵ�ֶ���������������ͺ���ı�����ӡ��
//����һ���������ĸ����root�������η��ض���������������ͺ�������(��ά�������ʽ)��

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class TreeToSequence1 {

	int[][] result;
	int i = 0;
	int j = 0;
	int k = 0;

	public int[][] convert(TreeNode root) {
		// write code here
		int size = getSize(root);
		result = new int[3][size];
		preOrder(root);
		inOrder(root);
		postOrder(root);
		return result;
	}

	public int getSize(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + getSize(root.left) + getSize(root.right);
	}

	public void preOrder(TreeNode root) {
		if (root == null)
			return;
		result[0][i++] = root.val;
		preOrder(root.left);
		preOrder(root.right);
	}

	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		result[1][j++] = root.val;
		inOrder(root.right);
	}

	public void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		result[2][k++] = root.val;
	}
}