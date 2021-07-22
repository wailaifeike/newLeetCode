package 数组;
/*
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，
 * 找出只包含 1 的最大矩形，并返回其面积。
 * 
 * */
public class _85_最大矩形 {
	
	public int maximalRectangle(char[][] matrix) {
		
		if (matrix.length == 0) {
	        return 0;
	    }
	    int[] heights = new int[matrix[0].length];
	    int maxArea = 0;
	    for (int row = 0; row < matrix.length; row++) {
	        //遍历每一列，更新高度
	        for (int col = 0; col < matrix[0].length; col++) {
	            if (matrix[row][col] == '1') {
	                heights[col] += 1;
	            } else {
	                heights[col] = 0;
	            }
	        }
	        //调用上一题的解法，更新函数
	        maxArea = Math.max(maxArea, largestRectangleArea(heights));
	    }
	    return maxArea;

    }
	
	public static int largestRectangleArea(int[] heights) {
		 int res = 0;
		 for (int i = 0; i < heights.length; i++) {
			if(i+1<heights.length&&heights[i]<=heights[i+1]) continue;
			int minH = heights[i];
			for (int j = i; j>=0; j--) {
				minH = Math.min(minH, heights[j]);
				int area = minH*(i-j+1);
				res = Math.max(res, area);
			}
		 }
		 return res;
	 }
}
