package 数组;

/*
 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
进阶：

一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个仅使用常量空间的解决方案吗？
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/set-matrix-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _73_矩阵置零 {
	public static void setZeroes(int[][] matrix) {
		if(matrix==null||matrix.length==0||matrix[0].length==0) return;
		int r = matrix.length;
		int c = matrix[0].length;
		boolean rowZero = false, colZero = false;
		
		for (int i = 0; i < r; ++i) {
	            if (matrix[i][0] == 0) colZero = true;
	    }
        for (int i = 0; i < c; ++i) {
            if (matrix[0][i] == 0) rowZero = true;
        } 
        
        for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if(matrix[i][j]==0){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
        
        for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if(matrix[0][j] == 0||matrix[i][0] == 0){
					matrix[i][j]=0;
				}
			}
		}
        
        if(rowZero){  // 行为0,初始化为列
        	for (int i = 0; i < c; ++i) matrix[0][i] = 0;
        }
        
        if(colZero){  // 行为0,初始化为列
        	for (int i = 0; i < r; ++i) matrix[i][0] = 0;
        }
        
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
    }
	
	
	public static void main(String[] args) {
		int[][] arr = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		setZeroes(arr);
	}
}
