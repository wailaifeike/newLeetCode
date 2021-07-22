package 数组;

public class _59_螺旋矩阵II {
	 public int[][] generateMatrix(int n) {
		 int[][] res = new int[n][n];
		 int start_i = 0,end_i=n-1;
		 int start_j = 0,end_j = n-1;
		 int val = 1;
		 while(true) {
			for(int j=start_j;j<=end_j;j++) {
				res[start_i][j] = val++;
			}
			if(++start_i>end_i) break;
			for(int i=start_i;i<=end_i;i++) {
				res[i][end_j] = val++;
			}
			if(--end_j<start_j) break;
			for(int j = end_j;j>=start_j;j--) {
				res[end_i][j] = val++;
			}
			if(--end_i<start_i) break;
			for(int i = end_i;i>=start_i;i--) {
				res[i][start_j] = val++;
			}
			if(++start_j>end_j) break;
			
		 }
		 
		 return res;

	 }
}
