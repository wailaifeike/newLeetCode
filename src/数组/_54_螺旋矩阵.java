package 数组;

import java.util.ArrayList;
import java.util.List;

/*
 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
示例 1：


输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 
 * */
public class _54_螺旋矩阵 {
	public static List<Integer> spiralOrder(int[][] matrix) {
		if(matrix==null) return new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		if(matrix.length==1){
			for(int a:matrix[0]){
				list.add(a);
			}
			
			return list;
		}
		if(matrix[0].length==1){
			for(int[] rows:matrix){
				list.add(rows[0]);
			}
			return list;
		}
		int start_i=0,start_j=0;
		
		int end_i = matrix.length-1,end_j = matrix[0].length-1;
		
		while (start_i<=end_i&&start_j<=end_j) {
			
			if(start_i==end_i){
				for(int i=start_j;i<=end_j;i++){
					list.add(matrix[start_i][i]);
				}
			}else if (start_j==end_j) {
				for(int i=start_i;i<=end_i;i++){
					list.add(matrix[i][start_j]);
				}
			}else {
				int curC = start_j;
				int curR = start_i;
				while (curC!=end_j) {
					list.add(matrix[start_i][curC]);
					curC++;	
				}
				while (curR!=end_i) {
					list.add(matrix[curR][end_j]);
					curR++;
					
				}
				while (curC!=start_j) {
					list.add(matrix[end_i][curC]);
					curC--;
				}
				
				while (curR!=start_i) {
					list.add(matrix[curR][start_j]);
					curR--;
				}
			}
			start_i+=1;
			start_j+=1;
			end_i-=1;
			end_j-=1;			
		}
		return list;
    }
	
	public static List<Integer> spiralOrder2(int[][] matrix) {
		if(matrix==null) return new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		 int start_i = 0,end_i=matrix.length-1;
		 int start_j = 0,end_j = matrix[0].length-1;
		 int val = 1;
		 while(true) {
			for(int j=start_j;j<=end_j;j++) {
				list.add(matrix[start_i][j]);
			}
			if(++start_i>end_i) break;
			for(int i=start_i;i<=end_i;i++) {
				list.add(matrix[i][end_j]);
			}
			if(--end_j<start_j) break;
			for(int j = end_j;j>=start_j;j--) {
				list.add(matrix[end_i][j]);
			}
			if(--end_i<start_i) break;
			for(int i = end_i;i>=start_i;i--) {
				list.add(matrix[i][start_j]);
			}
			if(++start_j>end_j) break;
			
		 }
		
		return list;
	}
	
	public static void main(String[] args) {
		//{1,2},{3,4}
		//{1,2,3},{4,5,6},{7,8,9}
		//{1,2,3,4},{5,6,7,8},{9,10,11,12}
		int[][] matrix = new int[][]{{1,2},{3,4}};
		List<Integer> res = spiralOrder(matrix);
		System.out.println(res);
	}
}
