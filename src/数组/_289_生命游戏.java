package 数组;

import javax.swing.text.StyledEditorKit.ForegroundAction;

//https://leetcode-cn.com/problems/game-of-life/

//https://github.com/grandyang/leetcode/issues/289
/*
 * 由于题目中要求用置换方法 in-place 来解题，所以就不能新建一个相同大小的数组，
 * 那么只能更新原有数组，题目中要求所有的位置必须被同时更新，但在循环程序中还是一个位置一个位置更新的，
 * 当一个位置更新了，这个位置成为其他位置的 neighbor 时，怎么知道其未更新的状态呢？可以使用状态机转换：

状态0： 死细胞转为死细胞

状态1： 活细胞转为活细胞

状态2： 活细胞转为死细胞

状态3： 死细胞转为活细胞

最后对所有状态对2取余，则状态0和2就变成死细胞，状态1和3就是活细胞，达成目的。先对原数组进行逐个扫描，对于每一个位置，扫描其周围八个位置，如果遇到状态1或2，就计数器累加1，扫完8个邻居，如果少于两个活细胞或者大于三个活细胞，而且当前位置是活细胞的话，标记状态2，如果正好有三个活细胞且当前是死细胞的话，标记状态3。完成一遍扫描后再对数据扫描一遍，对2取余变成我们想要的结果
 * 
 * 
 * */
public class _289_生命游戏 {
	public static void gameOfLife(int[][] board) {
		int rows = board.length;
		int cols = board[0].length;
		int[] x = new int[]{-1,-1,-1,0,1,1,1,0};
		int[] y = new int[]{-1,0,1,1,1,0,-1,-1};
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int count = 0;
				for (int k = 0; k < 8; k++) {
					int new_x = i+x[k];
					int new_y = j+y[k];
				
					//是活细胞的话,统计其邻居活细胞的数量
					if((new_x>=0&&new_x<rows)&&(new_y>=0&&new_y<cols)
						&&(board[new_x][new_y]==1||board[new_x][new_y]==2)){
						count++;
					}
					
				}
				
				if(board[i][j]==1&&(count<2||count>3)){
					board[i][j] = 2; // 活细胞变为死细胞
				}
				else if (board[i][j]==0&&count==3) {
					board[i][j] = 3; //死细胞 变为活细胞
				}
			}
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = board[i][j]%2;
			}
		}
		
    }

	
	public static void main(String[] args) {
		int[][] arr = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		gameOfLife(arr);
	}
	
}
