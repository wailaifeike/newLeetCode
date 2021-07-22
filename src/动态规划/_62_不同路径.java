package 动态规划;

/*
 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * */
public class _62_不同路径 {
	public static int uniquePaths(int m, int n) {
		if(m==1||n==1) return 1;
		
		int[][] dp = new int[m][n];
		for (int k = 0; k < n; k++) {
			dp[m-1][k] = 1;
		}
		for (int x = 0; x < m; x++) {
			dp[x][n-1] = 1;
		}
		
		dp[m-1][n-1] = 0;
		for (int i = m-2; i>=0; i--) {
			for (int j = n-2; j>=0; j--) {
				
				dp[i][j] = dp[i][j+1]+dp[i+1][j];
			}
		}
		return dp[0][0];
    }
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(3,3));
	}
}
