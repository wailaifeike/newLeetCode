package 动态规划;

/*
 * 
 *在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
示例 1：

输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * */
public class _221_最大正方形 {

	    public int maximalSquare(char[][] matrix) {
	        int maxSide = 0;
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return maxSide;
	        }
	        int rows = matrix.length, columns = matrix[0].length;
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < columns; j++) {
	                if (matrix[i][j] == '1') {
	                    // 遇到一个 1 作为正方形的左上角
	                    maxSide = Math.max(maxSide, 1);
	                    // 计算可能的最大正方形边长
	                    int currentMaxSide = Math.min(rows - i, columns - j);
	                    for (int k = 1; k < currentMaxSide; k++) {
	                        // 判断新增的一行一列是否均为 1
	                        boolean flag = true;
	                        if (matrix[i + k][j + k] == '0') {
	                            break;
	                        }
	                        for (int m = 0; m < k; m++) {
	                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
	                                flag = false;
	                                break;
	                            }
	                        }
	                        if (flag) {
	                            maxSide = Math.max(maxSide, k + 1);
	                        } else {
	                            break;
	                        }
	                    }
	                }
	            }
	        }
	        int maxSquare = maxSide * maxSide;
	        return maxSquare;
	    }
	    
	    
	    public int maximalSquare2(char[][] matrix) {
	    	int maxSide = 0;
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return maxSide;
	        }
	        int rows = matrix.length;
	        int cols = matrix[0].length;
	        
	        int[][] dp = new int[rows][cols];
	        
	        for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if(matrix[i][j]=='1') {
						if(i==0||j==0) { // 第一行或者第一列，边界条件
							dp[i][j] = 1;
						}else {
							dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1])+1;
						}
						
						 maxSide = Math.max(maxSide, dp[i][j]);
					}
				}
			}
 	    	return maxSide*maxSide;
	    }
	



}
