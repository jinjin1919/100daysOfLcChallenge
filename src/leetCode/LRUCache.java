package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	class DbLinkedNode {
        int key; 
        int val; 
        DbLinkedNode next; 
        DbLinkedNode prev; 

        public DbLinkedNode(int k, int val) {
            this.val = val; 
            this.key = k; 
        }
    }

    Map<Integer, DbLinkedNode> cache; 
    DbLinkedNode head; 
    DbLinkedNode tail; 
    int capacity;
    int size;  

    public LRUCache(int capacity) {
        head = new DbLinkedNode(0, 0); 
        tail = new DbLinkedNode(0, 0); 
        head.next = tail; 
        tail.prev = head; 
        cache = new HashMap<>(); 
        this.capacity = capacity; 
    }

    public void remove(DbLinkedNode node) {

        node.prev.next = node.next; 
        node.next.prev = node.prev; 

    }

    public void addToHead(DbLinkedNode node) {

        node.next = head.next; 
        head.next.prev = node; 
        node.prev = head; 
        head.next = node; 
        
    }
    
    public int get(int key) {
        
        if(!cache.containsKey(key)) return -1; 

        DbLinkedNode node = cache.get(key); 
        remove(node); 
        addToHead(node); 
        return node.val; 
    }

    public DbLinkedNode removeFromTail() {

        DbLinkedNode node = tail.prev; 
        node.prev.next = tail; 
        tail.prev = node.prev; 
        return node; 
    }
    
    public void put(int key, int value) {
        
        if(cache.containsKey(key)){
            DbLinkedNode node = cache.get(key); 
            node.val = value; 
            remove(node); 
            addToHead(node); 
          
        }else {
            
            DbLinkedNode newNode = new DbLinkedNode(key, value); 
            addToHead(newNode); 
            cache.put(key, newNode); 
            size++; 
            if(size > capacity){
                DbLinkedNode node = removeFromTail(); 
                cache.remove(node.key); 
            }

        }
    }
	

	public static void main(String[] args) {
		
		LRUCache lru = new LRUCache(2); 
		lru.put(1, 1);
		lru.put(2, 2);
		System.out.println(lru.get(1));
		lru.put(3, 3);
		System.out.println(lru.get(2));
		lru.put(4, 4);
		System.out.println(lru.get(1));
		System.out.println(lru.get(3));
		System.out.println(lru.get(4));

	}

}
