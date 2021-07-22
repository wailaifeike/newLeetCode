package 动态规划;



/*

给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。

示例 1：

输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _64_最小路径和 {
	 public static int minPathSum(int[][] grid) {
		 if(grid.length==1) {
			 int sum = 0;
			 for (int i = 0; i < grid[0].length; i++) {
				sum+=grid[0][i];
			 }
			 return sum;
		 }
		 if(grid[0].length==1) {
			 int sum = 0;
			 for (int i = 0; i < grid.length; i++) {
				sum+=grid[i][0];
			 }
			 return sum;
		 }
		 int rows = grid.length;
		 int cols = grid[0].length;
		 
		 int[][] dp = new int[rows][cols];
		 
		 dp[rows-1][cols-1] = grid[rows-1][cols-1];
		 
		 for (int i = cols-1; i>0; i--) {
			dp[rows-1][i-1] = grid[rows-1][i-1]+dp[rows-1][i];
		 }
		 
		 for (int i = rows-1; i>0; i--) {
				dp[i-1][cols-1] = grid[i-1][cols-1]+dp[i][cols-1];
		 }
		 
		 for (int i = rows-2; i>=0; i--) {
			for (int j = cols-2; j>=0; j--) {
				dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);			
			}
		 }
		 
		 
		 
		 return dp[0][0];
	 }
	 
	 
	 public static void main(String[] args) {
		 //{1,2,3},{4,5,6} {1,3,1},{1,5,1},{4,2,1}
		int[][] grid = new int[][] {{1,2,3},{4,5,6}};
		System.out.println(minPathSum(grid));
	}
}
