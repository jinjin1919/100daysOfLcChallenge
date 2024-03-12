package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import leetCode.MaxPathSum.TreeNode;

public class BuildTree {
	
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
	
	int[] preorder; 
    int index; 
    Map<Integer, Integer> idxMap = new HashMap<>(); 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder; 
        for(int i=0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i); 
        }

        return buildTreeHelper(0, inorder.length-1); 


    }

    public TreeNode buildTreeHelper(int left, int right) {

        if(left > right){
            return null; 
        }

        int val = preorder[index++]; 
        TreeNode root = new TreeNode(val); 

        root.left = buildTreeHelper(left, idxMap.get(val)-1); 
        root.right = buildTreeHelper(idxMap.get(val)+1, right); 

        return root; 
    }
    
    public void print(TreeNode root) {
		
    	LinkedList<TreeNode> que = new LinkedList<>(); 
    	
    	que.offer(root); 
    	List<String> res = new ArrayList<>(); 
    	
    	while(!que.isEmpty()) {
    		TreeNode node = que.removeFirst(); 
    		if(node != null) {
    			res.add(String.valueOf(node.val)); 
    			que.offer(node.left); 
    			que.offer(node.right); 
    		}else {
    			res.add("null"); 
    		}
    		
    	}
    	
    	System.out.println(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {3,9,20,15,7}; 
		int[] inorder = {9,3,15,20,7}; 
		
		BuildTree bt = new BuildTree(); 
		TreeNode root = bt.buildTree(preorder, inorder); 
		bt.print(root); 
		

	}

}
