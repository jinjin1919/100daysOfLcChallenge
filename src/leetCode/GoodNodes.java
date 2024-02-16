package leetCode;

public class GoodNodes {

	static class TreeNode {
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

	int count;

	public int goodNodes(TreeNode root) {

		if (root == null)
			return count;

		dfs(root, Integer.MIN_VALUE);

		return count;

	}

	public void dfs(TreeNode root, int max) {

		if (root == null) {
			return;
		}

		if (root.val >= max) {
			count++;
		}
		max = Math.max(root.val, max);

		dfs(root.left, max);
		dfs(root.right, max);

	}
	
	public static void main(String[] args) {
		
		GoodNodes gn = new GoodNodes(); 
		TreeNode n1 = new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null); 
		
		System.out.println(gn.goodNodes(n1));
	}

}
