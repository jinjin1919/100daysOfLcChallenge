package leetCode;

public class MaxIsland {
	
	int max = 0; 
    int m; 
    int n; 
    public int maxAreaOfIsland(int[][] grid) {
        
        m = grid.length; 
        n = grid[0].length; 
        for(int i=0; i < m; i++) {
            for(int j=0; j < n; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(dfs(grid, i, j), max); 
                }
            }
        }

        return max; 
    }

    public int dfs(int[][] grid, int row, int col) {

        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
            return 0; 
        }

        grid[row][col] = 0; 

        return 1 + dfs(grid, row+1, col) + dfs(grid, row-1, col) + dfs(grid, row, col+1) + dfs(grid, row, col-1); 
    }

	public static void main(String[] args) {
		
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},
						{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		MaxIsland mi = new MaxIsland(); 
		System.out.println(mi.maxAreaOfIsland(grid));
		
	}

}
