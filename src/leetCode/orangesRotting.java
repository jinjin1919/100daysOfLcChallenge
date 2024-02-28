package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class orangesRotting {

	public static int orangesRotting(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		int totalFresh = 0;

		Deque<int[]> que = new ArrayDeque<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					que.offer(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					totalFresh++;
				}
			}
		}

		if (totalFresh == 0)
			return 0;

		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

		int min = 0;
		while (!que.isEmpty()) {

			if (totalFresh == 0) {
				return min;
			}

			int size = que.size();
			for (int i = 0; i < size; i++) {
				int[] cell = que.poll();
				int row = cell[0];
				int col = cell[1];

				for (int[] dir : dirs) {
					int nr = row + dir[0];
					int nc = col + dir[1];

					if (nr < 0 || nr >= m || nc < 0 || nc >= n)
						continue;
					if (grid[nr][nc] == 1) {
						grid[nr][nc] = 2;
						totalFresh--;
						que.offer(new int[] { nr, nc });
					}
				}
			}
			min++;
		}

		return -1;
	}

	public static void main(String[] args) {
		
		int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
		System.out.println(orangesRotting(grid));

	}

}
