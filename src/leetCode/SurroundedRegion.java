package leetCode;

public class SurroundedRegion {
	
	int m; 
    int n; 
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 

    public void solve(char[][] board) {
        
        m = board.length; 
        n = board[0].length; 

        for(int i=0; i < m; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0); 
            }
            if(board[i][n-1] == 'O') {
                dfs(board, i, n-1); 
            }
        }

        for(int j=0; j < n; j++) {
            if(board[0][j] == 'O') {
                dfs(board, 0, j); 
            }
            if(board[m-1][j] == 'O') {
                dfs(board, m-1, j); 
            }
        }

        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(board[i][j] == 'R') {
                    board[i][j] = 'O'; 
                }else {
                    board[i][j] = 'X'; 
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {

        board[i][j] = 'R'; 
        for(int[] dir: dirs) {
            int nr = i + dir[0]; 
            int nc = j + dir[1]; 

            if(nr < 0 || nr >= m || nc < 0 || nc >= n || board[nr][nc] != 'O'){
                continue; 
            } 
            dfs(board, nr, nc); 
        }
    }
    
    public void printBoard(char[][] board) {
    	
    	for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }

	public static void main(String[] args) {
		

		char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
		SurroundedRegion sr = new SurroundedRegion(); 
		System.out.println("Before the function call: ");
		sr.printBoard(board);
		System.out.println("After the function call: ");
		sr.solve(board); 
		sr.printBoard(board);

	}

}
