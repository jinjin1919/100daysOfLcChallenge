package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {
	
	class TrieNode {
        Map<Character, TrieNode> children;  
        String endOfWord; 
        public TrieNode(){
            children = new HashMap<>();  
        }
    }

    TrieNode root; 
    static int m; 
    static int n; 
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 

    public List<String> findWords(char[][] board, String[] words) {
        
        m = board.length; 
        n = board[0].length; 
        
        root = new TrieNode(); 
        for(String word: words) {
            addWord(word); 
        }

        List<String> res = new ArrayList<>(); 
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(root.children.containsKey(board[i][j])) {
                    backtrack(res, board, root, i, j); 
                }
            }
        }

        return res; 
    }

    public void backtrack(List<String> res, char[][] board, TrieNode curr, int row, int col) {

        curr = curr.children.get(board[row][col]); 

        if(curr.endOfWord != null) {
            res.add(curr.endOfWord); 
            curr.endOfWord = null; 
        }

        char letter = board[row][col]; 
        board[row][col] = '*'; 

        for(int[] dir: dirs) {
            int nr = row + dir[0]; 
            int nc = col + dir[1]; 

            if(nr < 0 || nr >= m || nc < 0 || nc >= n || !curr.children.containsKey(board[nr][nc])){
                continue; 
            }

            backtrack(res, board, curr, nr, nc); 
        }

        board[row][col] = letter; 

        
    }

    public void addWord(String word) {
        
        TrieNode curr = root; 
        for(char ch: word.toCharArray()) {
            if(!curr.children.containsKey(ch)) {
                curr.children.put(ch, new TrieNode()); 
            }
            curr = curr.children.get(ch); 
        }
        curr.endOfWord = word; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain"}; 
		
		WordSearchII ws = new WordSearchII(); 
		
		System.out.println(ws.findWords(board, words));
		

	}

}
