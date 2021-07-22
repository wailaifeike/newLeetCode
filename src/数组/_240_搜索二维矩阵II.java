package 数组;


/*
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
 

示例 1：

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * */
public class _240_搜索二维矩阵II {
	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;
        if(target<matrix[0][0]||target>matrix[rows-1][cols-1]) return false;     	
        int x = rows-1, y = 0;
        while (true) {
            if (matrix[x][y] > target) --x;
            else if (matrix[x][y] < target) ++y;
            else if(matrix[x][y]==target) return true;
            if (x < 0 || y >= cols) break;
        }
        return false;	
    }
}
