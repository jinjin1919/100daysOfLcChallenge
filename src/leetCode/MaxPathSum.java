package leetCode;

public class MaxPathSum {

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

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		maxPathSumHelper(root);
		return max;
	}

	public int maxPathSumHelper(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = Math.max(0, maxPathSumHelper(root.left));
		int right = Math.max(0, maxPathSumHelper(root.right));
		int straight = root.val + Math.max(left, right);

		int case2 = Math.max(root.val + left + right, straight);

		max = Math.max(max, case2);

		return straight;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))); 
		MaxPathSum mps = new MaxPathSum(); 
		System.out.println(mps.maxPathSum(root));

	}

}
