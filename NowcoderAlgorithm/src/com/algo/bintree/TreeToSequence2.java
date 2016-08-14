package com.algo.bintree;

import java.util.Stack;

//���÷ǵݹ鷽ʽʵ�ֶ���������������ͺ���ı�����ӡ��
//����һ���������ĸ����root�������η��ض���������������ͺ�������(��ά�������ʽ)��

public class TreeToSequence2 {

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
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				result[0][i++] = root.val;
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				root = root.right;
			}
		}
	}

	public void inOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				result[1][j++] = root.val;
				root = root.right;
			}
		}
	}

	public void postOrder(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		while (root != null || !stack1.isEmpty()) {
			while (root != null) {
				stack1.push(root);
				stack2.push(root);
				root = root.right;
			}
			if (!stack1.isEmpty()) {
				root = stack1.pop();
				root = root.left;
			}
		}
		while (!stack2.isEmpty()) {
			result[2][k++] = stack2.pop().val;
		}
	}
}