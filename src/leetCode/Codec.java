package leetCode;

import java.util.Arrays;
import java.util.LinkedList;

public class Codec {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x; 
		}

		TreeNode(int x, TreeNode left, TreeNode rgt) {
			val = x;
			this.left = left; 
			this.right = rgt; 
		}
		
	}
	
	public void print(TreeNode root) {
		StringBuilder sb = new StringBuilder(); 
		dfs(root, sb); 
		System.out.println(sb.toString());
	}
	
	public void dfs(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("null").append(",");
			return;
		}

		sb.append(root.val).append(",");
		dfs(root.left, sb);
		dfs(root.right, sb);
	}

	public String serialize(TreeNode root) {

		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);

		return sb.toString();
	}

	public void serializeHelper(TreeNode root, StringBuilder sb) {

		if (root == null) {
			sb.append("null").append(",");
			return;
		}

		sb.append(root.val).append(",");
		serializeHelper(root.left, sb);
		serializeHelper(root.right, sb);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		LinkedList<String> dataLst = new LinkedList<>(Arrays.asList(data.split(",")));

		return deserialHelper(dataLst);
	}

	public TreeNode deserialHelper(LinkedList<String> dataLst) {

		String val = dataLst.removeFirst();
		if (val.equals("null")) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left = deserialHelper(dataLst);
		root.right = deserialHelper(dataLst);

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))); 
		
		Codec codec = new Codec(); 
		codec.print(root);
		System.out.println("-----------"); 
		Codec ser = new Codec();
		Codec deser = new Codec();
		TreeNode ans = deser.deserialize(ser.serialize(root));
		deser.print(ans);
		
	}

}
