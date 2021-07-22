package DFS_BFS;

/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
示例 1：

输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _200_岛屿数量 {
	 public static int numIslands(char[][] grid) {
		 if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
				return 0;
			}
			int N = grid.length;
			int M = grid[0].length;
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] == '1') {
						res++;
						infect(grid, i, j, N, M);
					}
				}
		}
		return res;
		 
	
	 }
	 
	// 目前来到m[i][j], 经历上下左右的感染过程
		public static void infect(char[][] m, int i, int j, int N, int M) {
			if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != '1') {
				return;
			}
			m[i][j] = '2';
			infect(m, i + 1, j, N, M);
			infect(m, i - 1, j, N, M);
			infect(m, i, j + 1, N, M);
			infect(m, i, j - 1, N, M);
		}
		
		
		 public int numIslands2(char[][] grid) {
			if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
					return 0;
	         }
			int rows = grid.length;
			int cols = grid[0].length;
			int res = 0;
			boolean[][] visted = new boolean[rows][cols];
			
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if(grid[i][j]=='0'||visted[i][j]) continue;
					helper(grid,visted,i,j);
					++res;
				}
			}
			 return res;
		 }

		private void helper(char[][] grid, boolean[][] visited, int x, int y) {
		     if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length 
		    		 || grid[x][y] == '0' || visited[x][y]) return;
		     
		     visited[x][y] = true;
		     
		     helper(grid, visited, x - 1, y);
		     helper(grid, visited, x + 1, y);
		     helper(grid, visited, x, y - 1);
		     helper(grid, visited, x, y + 1);
			
		}
		
		
		
		
}
