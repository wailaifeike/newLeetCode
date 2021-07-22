package 动态规划;

import java.awt.image.RescaleOp;
import java.util.Iterator;

/*
给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。

下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。
在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。

示例 1：
输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
输出：13
解释：下面是两条和最小的下降路径，用加粗标注：
[[2,1,3],      [[2,1,3],
 [6,5,4],       [6,5,4],
 [7,8,9]]       [7,8,9]]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _931_下降路径最小和 {
	public int minFallingPathSum(int[][] matrix) {
		int ans = Integer.MAX_VALUE;
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		if(rows==1&&cols==1) return matrix[0][0];
		int[][] dp = new int[rows][cols];
		
		for (int k = 0; k < cols; k++) {
			dp[0][k] = matrix[0][k];
		}
		
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int pre = dp[i-1][j];
				if(j>0) pre = Math.min(pre, dp[i-1][j-1]);
				if(j<cols-1) pre = Math.min(pre, dp[i-1][j+1]);
				dp[i][j] = matrix[i][j]+pre;
				
				if(i==rows-1) ans = Math.min(ans, dp[i][j]);
			}
		}
			
		return ans;
		
		
    }
}
