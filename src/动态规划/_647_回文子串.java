package 动态规划;



/*
 
 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
示例 1：
输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindromic-substrings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _647_回文子串 {
	
	 // 每一个字符当做回文的中心，向两边扩展
	//字符串中的每一个字符都当作回文串中间的位置，然后向两边扩散，每当成功匹配两个左右两个字符，结果 res 自增1，然后再比较下一对
	 public static int countSubstrings(String s) {
		 int res = 0;
		 for (int i = 0; i < s.length(); i++) {
				res+=Process(s,i,i)+Process(s,i,i+1);
		  }
		 return res;
	 }
	 
	 
	 

	private static int Process(String s, int i, int j) {
		int count = 0;
		while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)) {
			count++;
			i--;
			j++;
		}
		return count;
	}
	
	
	 //  动态规划
	 public static int countSubstrings2(String s) {
		 int res = 0;
		 int len = s.length();
		 boolean[][] dp = new boolean[len][len];
		 for (int i = len-1; i>=0; i--) {
				for (int j = i; j < len; j++) {
					//j-i<=2 表示两个字符相邻或者差一个字符
					dp[i][j] = (s.charAt(i)==s.charAt(j))&&((j-i<=2)||dp[i+1][j-1]);
					if(dp[i][j]) res++;
				}
		  }
		 return res;
	 }

	public static void main(String[] args) {
		System.out.println(countSubstrings("abcba"));
		System.out.println(countSubstrings2("abcba"));
	}
}
