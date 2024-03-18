package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic {
	
	int m; 
    int n; 

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacificReach = new boolean[m][n]; 
        boolean[][] atlanticReach = new boolean[m][n]; 

        for(int i=0; i < m; i++) {
            pacificReach[i][0] = true; 
            atlanticReach[i][n-1] = true; 
        } 

        for(int j=0; j < n; j++) {
            pacificReach[0][j] = true; 
            atlanticReach[m-1][j] = true; 
        }

        for(int i=0; i < m; i++) {
            dfs(heights, pacificReach, i, 0); 
            dfs(heights, atlanticReach, i, n-1); 
        }

        for(int j=0; j < n; j++) {
            dfs(heights, pacificReach, 0, j);
            dfs(heights, atlanticReach, m-1, j);  
        }

        List<List<Integer>> res = new ArrayList<>(); 

        for(int i=0; i < m; i++) {
            for(int j=0; j <n; j++) {
                if(pacificReach[i][j] && atlanticReach[i][j]) {
                    res.add(Arrays.asList(i, j));  
                }
            }
        }

        return res; 
    }

    public void dfs(int[][] heights, boolean[][] reachOcean, int i, int j) {

        reachOcean[i][j] = true; 
        for(int[] dir: dirs) {
            int nr = i + dir[0]; 
            int nc = j + dir[1]; 

            if(nr < 0 || nr >= m || nc < 0 || nc >= n || reachOcean[nr][nc] || heights[nr][nc] < heights[i][j]) {
                continue; 
            }
            dfs(heights, reachOcean, nr, nc); 
        }

        
    }

	public static void main(String[] args) {
		
		int[][] heights = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}}; 
		PacificAtlantic pa = new PacificAtlantic(); 
		System.out.println(pa.pacificAtlantic(heights));

	}

}
