package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

	public class TreeNode {

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

	Map<TreeNode, TreeNode> parent;
	Map<Integer, Integer> memo;
	Set<TreeNode> nodes;
	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		parent = new HashMap<>();
		memo = new HashMap<>();
		nodes = new HashSet<>();
		denoteParent(root, null);

		for (TreeNode n : nodes) {
			maxSum = Math.max(maxSum, dfs(n));
		}

		return maxSum;

	}

	public int dfs(TreeNode node) {

		if (memo.containsKey(node.val)) {
			return memo.get(node.val);
		}

		int left = Integer.MIN_VALUE;
		int right = Integer.MIN_VALUE;
		int pare = Integer.MIN_VALUE;

		if (node.left != null) {
			left = node.val + dfs(node.left);
		}

		if (node.right != null) {
			right = node.val + dfs(node.right);
		}

		if (parent.get(node) != null) {
			pare = node.val + dfs(parent.get(node));
		}

		int currMax = Math.max(Math.max(left, right), pare);

		memo.put(node.val, currMax);

		maxSum = Math.max(maxSum, currMax);

		return maxSum;

	}

	public void denoteParent(TreeNode root, TreeNode par) {

		if (root != null && par != null) {
			parent.put(root, par);
			nodes.add(root);
			nodes.add(par);
		}
		// leaf node max sum is its value;
		
		if (root != null && root.left != null) {
			denoteParent(root.left, root);
		}
		if (root != null && root.right != null) {
			denoteParent(root.right, root);
		}
	}
	
	public static void main(String[] args) {
		
		Solution sol = new Solution(); 
		TreeNode root = sol.new TreeNode(1); 
		TreeNode l2 = sol.new TreeNode(2); 
		TreeNode r2 = sol.new TreeNode(3); 
		
		root.left = l2; 
		root.right = r2; 
		
		System.out.println(sol.maxPathSum(root)); 
		
		
	}
}
	
	



