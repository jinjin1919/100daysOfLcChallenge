package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrder {

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

	public static List<List<Integer>> verticalOrder(TreeNode root) {

		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		Map<TreeNode, Integer> colMap = new HashMap<>();

		if (root == null)
			return new ArrayList<>();

		Deque<TreeNode> que = new ArrayDeque<>();
		colMap.put(root, 0);
		que.offer(root);

		while (!que.isEmpty()) {
			TreeNode node = que.poll();
			int col = colMap.get(node);
			map.computeIfAbsent(col, k -> new ArrayList<>()).add(node.val);

			if (node.left != null) {
				que.offer(node.left);
				colMap.put(node.left, col - 1);
			}

			if (node.right != null) {
				que.offer(node.right);
				colMap.put(node.right, col + 1);
			}
		}

		return new ArrayList<>(map.values());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		System.out.println(verticalOrder(root));
		
	}

}
