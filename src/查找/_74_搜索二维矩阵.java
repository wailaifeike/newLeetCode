package 查找;

/*
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _74_搜索二维矩阵 {
	 public static boolean searchMatrix(int[][] matrix, int target) {
		 int rows = matrix.length;
		 int cols = matrix[0].length;	 
		 int location_row = 0;
		 for (int i = 0; i < rows; i++) {
			if(target<=matrix[i][cols-1]) {
				location_row = i;
				break;
			}else {
				location_row++;
			}
		 }
		 if(location_row==rows) return false;
		 System.out.println(location_row);
		 return binaryFind(matrix, target, location_row);
	 }
	 
	 public static boolean binaryFind(int[][] matrix,int target,int index) {
		 if(target<matrix[index][0]) return false;
		 
		 int left = 0;
		 int right = matrix[0].length;
		 while (left<=right) {
			int mid = (left+right)/2;
			if(matrix[index][mid]==target) return true;
			else if (matrix[index][mid]>target) {
				right = mid-1;
			}else {
				left = mid+1;
			}
			
		}
		 return false;
	 }
	 
	 public static void main(String[] args) {
		//{1,3,5,7},{10,11,16,20},{23,30,34,60}
		int[][] matrix = {{1},{3}};
		int target = 3;
		System.out.println(searchMatrix(matrix,target));
	}
}
