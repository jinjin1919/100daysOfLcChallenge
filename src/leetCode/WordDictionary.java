package leetCode;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad")); // return False
		System.out.println(wordDictionary.search("bad")); // return True
		System.out.println(wordDictionary.search(".ad")); // return True
		System.out.println(wordDictionary.search("b..")); // return True

	}
	
	class TrieNode {
        Map<Character, TrieNode> children; 
        boolean endOfWord; 

        public TrieNode() {
            children = new HashMap<>(); 
        }
    }

    TrieNode root; 

    public WordDictionary() {
        root = new TrieNode(); 
    }
    
    public void addWord(String word) {
        
        TrieNode curr = root; 
        for(char ch: word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch, new TrieNode()); 
            }
            curr = curr.children.get(ch); 
        }
        curr.endOfWord = true; 
    }
    
    public boolean search(String word) {
        return searchInNode(word, root); 
    }

    public boolean searchInNode(String word, TrieNode node) {

        for(int i=0; i < word.length(); i++){
            char ch = word.charAt(i); 
            if(!node.children.containsKey(ch)){
                if(ch == '.'){
                    for(char each: node.children.keySet()){
                        TrieNode next = node.children.get(each); 
                        if(searchInNode(word.substring(i+1), next)){
                            return true; 
                        }
                    }
                }
                return false; 
            }
            
            node = node.children.get(ch); 
            
        }

        return node.endOfWord; 
    }

}
