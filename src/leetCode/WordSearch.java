package leetCode;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}; 
		System.out.println(exist(board, "ABCCED"));

	}
	
	static int m; 
    static int n; 
    public static boolean exist(char[][] board, String word) {
        
        m = board.length; 
        n = board[0].length; 

        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(backtrack(board, word, 0, i, j)){
                    return true; 
                }
            }
        }

        return false; 
        
    }

    public static boolean backtrack(char[][] board, String word, int index, int r, int c) {

        if(index == word.length()){
            return true; 
        }

        if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(index)) {
            return false; 
        }

        char letter = board[r][c]; 
        board[r][c] = '*'; 

        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; 

        for(int[] dir: dirs) {
            int nr = r + dir[0]; 
            int nc = c + dir[1]; 

            if(backtrack(board, word, index+1, nr, nc)){
                return true; 
            }
        }
        board[r][c] = letter; 
        return false; 
    }

}
