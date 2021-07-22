package 字符串;

public class _72_编辑距离 {
	public int minDistance(String word1, String word2) {
		 int m = word1.length(), n = word2.length();
	     int[][] memo = new int[m][n];
	     return helper(word1, 0, word2, 0, memo); 
	 }
	private int helper(String word1, int i, String word2, int j, int[][] memo) {
		// TODO Auto-generated method stub
		if(i==word1.length()) return word2.length()-j;
		if(j==word2.length()) return word1.length()-i;
		if(memo[i][j]>0) return memo[i][j];
		int res = 0;
		if(word1.charAt(i)==word2.charAt(j)) {
			return helper(word1, i+1, word2, j+1, memo);
		}else {
			 int insertCnt = helper(word1, i, word2, j + 1, memo);
	         int deleteCnt = helper(word1, i + 1, word2, j, memo);
	         int replaceCnt = helper(word1, i + 1, word2, j + 1, memo);
	         res = Math.min(insertCnt, Math.min(deleteCnt, replaceCnt)) + 1;
		}
		return memo[i][j] = res;
	}
}
