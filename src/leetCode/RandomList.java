package leetCode;

import java.util.HashMap;
import java.util.Map;

public class RandomList {
	
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	
	public Node copyRandomList(Node head) {
        
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(0); 
        Node curr = head; 
        Node cur2 = newHead; 

        while(curr != null) {
        
            Node clone = null; 
            if(!map.containsKey(curr)){
                clone = new Node(curr.val); 
                map.put(curr, clone); 
            }else {
                clone = map.get(curr); 
            }

            if(curr.random != null) {
                Node rand = curr.random; 
                if(!map.containsKey(rand)) {
                    Node node = new Node(rand.val); 
                    clone.random = node; 
                    map.put(rand, node); 
                }else {
                    clone.random = map.get(rand); 
                }
            }
            cur2.next = clone; 
            curr = curr.next; 
            cur2 = cur2.next; 
        }
        return newHead.next;  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
