package 动态规划;

/*
 *在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 *你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 *给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
示例 1:
输入: 
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 * */
public class _剑指Offer47礼物的最大价值 {
	public int maxValue(int[][] grid) {
		// 边界条件判断
		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		// 初始化dp的最上面一行，从左到右累加
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		// 初始化dp的最左边一列，从上到下累加
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[m - 1][n - 1];
	}

	public int maxValue2(int[][] grid) {
		// 边界条件判断
		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		// 初始化dp的最上面一行，从左到右累加
		for (int i = 1; i < n; i++) {
			grid[0][i] += grid[0][i - 1];
		}
		// 初始化dp的最左边一列，从上到下累加
		for (int i = 1; i < m; i++) {
			grid[i][0] += grid[i - 1][0];
		}

		// 下面是递推公式的计算
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
			}
		}
		return grid[m - 1][n - 1];
	}

	public int maxValue3(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		// 数组改成一维的
		int[] dp = new int[n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[j + 1] = Math.max(dp[j], dp[j + 1]) + grid[i][j];
			}
		}
		return dp[n];
	}
}
