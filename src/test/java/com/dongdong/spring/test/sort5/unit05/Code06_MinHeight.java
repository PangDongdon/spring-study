package com.dongdong.spring.test.sort5.unit05;

public class Code06_MinHeight {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public static int minDepth1(TreeNode head) {
		if (head == null) {
			return 0;
		}
		return process(head, 1);
	}

	public static int process(TreeNode head, int level) {
		if (head.left == null && head.right == null) {
			return level;
		}
		int ans = Integer.MAX_VALUE;
		if (head.left != null) {
			ans = Math.min(process(head.left, level + 1), ans);
		}
		if (head.right != null) {
			ans = Math.min(process(head.right, level + 1), ans);
		}
		return ans;
	}

	// 根据morris遍历改写
	public static int minDepth2(TreeNode head) {
		if (head == null) {
			return 0;
		}
		TreeNode cur = head;
		TreeNode mostRight = null;
		int curLevel = 0;
		int minHeight = Integer.MAX_VALUE;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {
				int leftHeight = 1;
				while (mostRight.right != null && mostRight.right != cur) {
					leftHeight++;
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) { // 第一次到达
					curLevel++;
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else { // 第二次到达
					if (mostRight.left == null) {
						minHeight = Math.min(minHeight, curLevel);
					}
					curLevel -= leftHeight;
					mostRight.right = null;
				}
			} else { // 只有一次到达
				curLevel++;
			}
			cur = cur.right;
		}
		int finalRight = 1;
		cur = head;
		while (cur.right != null) {
			finalRight++;
			cur = cur.right;
		}
		if (cur.left == null && cur.right == null) {
			minHeight = Math.min(minHeight, finalRight);
		}
		return minHeight;
	}

	// morris遍历，没有被调用，只是根据该方法改写出上面的方法
	public static void morris(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode cur1 = head;
		TreeNode cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			cur1 = cur1.right;
		}
	}

}
