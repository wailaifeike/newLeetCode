package 动态规划;



/*
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。

 

示例 1：

输入：matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
输出：15
解释： 
边长为 1 的正方形有 10 个。
边长为 2 的正方形有 4 个。
边长为 3 的正方形有 1 个。
正方形的总数 = 10 + 4 + 1 = 15.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _1277_统计全为1的正方形子矩阵 {
	public static int countSquares(int[][] matrix) {

		int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] dp = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(matrix[i][j]==1) {
					if(i==0||j==0) { // 第一行或者第一列，边界条件
						dp[i][j] = 1;
					}else {
						dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1])+1;
					}
					
					 maxSide = Math.max(maxSide, dp[i][j]);
				}
			}
		}
       
        //System.out.println(maxSide);
        int count = 0;  
        for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				//System.out.println(dp[i][j]);
				if(dp[i][j]!=0) {
//					if(dp[i][j]%maxSide==0) 
//					if(dp[i][j]==1) count+=1;
//					if(dp[i][j]==2) count+=2;
//					if(dp[i][j]==3) count+=3;
					if(dp[i][j]%maxSide==0) {
						count+=maxSide;
					}else {
						count+=dp[i][j];
					}
					
				}
			}
		}	   
		return count;
    }
	
	public static void main(String[] args) {
		//{0,1,1,1},{1,1,1,1},{0,1,1,1} {1,0,1},{1,1,0},{1,1,0}
		int[][] matrix = new int[][] {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
		
		System.out.println(countSquares(matrix));
	}
}
