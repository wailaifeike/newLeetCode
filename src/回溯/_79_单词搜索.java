package 回溯;

import java.awt.Checkbox;

/*
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search

 * 
 * */
public class _79_单词搜索 {
	
	static int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
	static int rows;
	static int cols;
	
	public static boolean exist(char[][] board, String word) {	
		rows = board.length;
		cols = board[0].length;
		boolean[][] visted = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				
				boolean find = check(word,board,i,j,visted,0);
				if(find) return true;
			}
		}
 		
		return false;
    }
	
	private static boolean check(String word,char[][] board, int i, int j, boolean[][] visted,int index) {
		
		if (index == word.length()-1) {
            return board[i][j] == word.charAt(index);
        }

		if(board[i][j] == word.charAt(index)){
			visted[i][j] = true;	
			 for (int[] direction : directions) {
	                int newX = i + direction[0];
	                int newY = j + direction[1];
	                if ((newX>=0&&newX<rows)&&(newY>=0&&newY<cols)&&!visted[newX][newY]) {
	                    if (check(word, board, newX,newY, visted, index+1)) {
	                        return true;
	                    }
	                }
	            }
			 visted[i][j] = false;
		}
		
		return false;
	}
	
	
	
	
	//第二种方法更优化
	
	public static boolean exist2(char[][] board, String word) {
		char[] w = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (process(board, i, j, w, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	// 目前到达了b[i][j]，word[k....]
	// 从b[i][j]出发，能不能搞定word[k....]  true  false
	public static boolean process(char[][] b, int i, int j, char[] w, int k) {
        if(k == w.length) {
			return true;
		}
        // k 有字符
		if (i < 0 || i == b.length || j < 0 || j == b[0].length) {
			return false;
		}
		if (b[i][j] != w[k]) {
			return false;
		}
		char tmp = b[i][j];
		b[i][j] = 0;
		boolean ans =  process(b, i - 1, j, w, k + 1) 
				|| process(b, i + 1, j, w, k + 1) 
				|| process(b, i, j - 1, w, k + 1)
				|| process(b, i, j + 1, w, k + 1);
		b[i][j] = tmp;
		return ans;
	}
	
	
	public static void main(String[] args) {
		char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String wordString1 = "ABCB";
		String wordString2 = "ABCCED";
		String wordString3 = "SEE";
		
		System.out.println(exist(board,wordString1));
		System.out.println(exist(board,wordString2));
		System.out.println(exist(board,wordString3));
	}


}
