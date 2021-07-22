package 查找;

import java.util.Iterator;

/*
 * 
给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
给你一个有效的甲板，仅由战舰或者空位组成。
战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，
或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/battleships-in-a-board
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 * */
public class _419_甲板上的战舰 {
	public int countBattleships(char[][] board) {
		int rows = board.length;
		int cols = board[0].length;
		int res = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(board[i][j]=='X') {
					res++;
					//行初始为"."
					int m = i;
					int n = j+1;
					while(n<cols&&board[m][n]=='X') {
						board[m][n]='.';
						n++;
					}
					
					//列初始为"."
					m = i+1;
					n = j;
					while(m<rows&&board[m][n]=='X') {
						board[m][n]='.';
						m++;
					}
				}
			}
		}
		return res;
    }
}
