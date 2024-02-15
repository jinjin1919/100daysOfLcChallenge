package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	
	static class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	    
	}
	
    public Node cloneGraph(Node node) {
        
        if(node == null) return null; 
        Node newNode = new Node(node.val); 
        Map<Node, Node> visited = new HashMap<>(); 
        visited.put(node, newNode); 
        dfs(node, visited); 

        return newNode; 
    }

    public void dfs(Node node, Map<Node, Node> visited) {

        for(Node nei: node.neighbors) {
            if(!visited.containsKey(nei)){
                Node newNei = new Node(nei.val); 
                visited.put(nei, newNei); 
                dfs(nei, visited); 
            }
            visited.get(node).neighbors.add(visited.get(nei)); 
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(1); 
		Node n2 = new Node(2); 
		Node n3 = new Node(3); 
		Node n4 = new Node(4); 
		n1.neighbors.add(n2); 
		n1.neighbors.add(n4); 
		
		n2.neighbors.add(n1); 
		n2.neighbors.add(n3); 
		
		n3.neighbors.add(n2); 
		n3.neighbors.add(n4); 
		
		n4.neighbors.add(n1); 
		n4.neighbors.add(n3); 
		
		
		
		
	}

}
