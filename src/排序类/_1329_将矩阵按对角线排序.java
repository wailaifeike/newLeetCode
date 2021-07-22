package 排序类;

public class _1329_将矩阵按对角线排序 {
	public  int[][] diagonalSort(int[][] mat) {
		
		int rows = mat.length;
		int cols = mat[0].length;
		
		for(int i=0;i<cols;i++) {
			bubbleSort(mat,0,i,rows,cols);
		}
		
	   for (int i = 1; i < rows; i++) {
		   bubbleSort(mat,i,0,rows,cols);
        }
		
		return mat;
    }

	private void bubbleSort(int[][] mat, int i,int j, int rows, int cols) {
		int tmp;
		for(;i<rows-1&&j<cols-1;i++,j++) {
			for(int m=i+1,n=j+1;m<rows&&n<cols;m++,n++) {
				if(mat[m][n]<mat[i][j]) {
					tmp = mat[m][n];
					mat[m][n] = mat[i][j];
					mat[i][j] = tmp;
				}
			}
		}
		// TODO Auto-generated method stub
		
	}
	
	public int[][] diagonalSort2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        //先对以第一行为起点的对角线排序
        for (int i = 0; i < n; i++) {
            okc(mat,0,i,m,n);
        }
        //再对以第一列为起点的对角线排序
        //起点[0，0]处已经排过序，所以i=1
        for (int i = 1; i < m; i++) {
            okc(mat,i,0,m,n);
        }
        return mat;
    }
    public int[][] okc(int[][] mat, int i, int j, int m, int n){
        int temp;
        //冒泡排序
        for( ;i<m-1&&j<n-1;i++,j++ ){
            for (int k = i+1,p=j+1; k < m&&p<n; k++,p++) {
                if (mat[k][p]<mat[i][j]){
                    temp = mat[k][p];
                    mat[k][p] = mat[i][j];
                    mat[i][j] = temp;
                }
            }
        }
        return mat;
    }

	
	public static void main(String[] args) {
		
	}
}
