package leetCode;

import java.util.ArrayDeque;

public class KthSmallest {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int kthSmallest(TreeNode root, int k) {

		ArrayDeque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;
		while (true) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();
			if (--k == 0) {
				return curr.val;
			}
			curr = curr.right;
		}

	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)); 
		KthSmallest ks = new KthSmallest(); 
		System.out.println(ks.kthSmallest(root, 2));
	}
}
