package 动态规划;

/*
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

'A' -> 1
'B' -> 2
...
'Z' -> 26
要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，
从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */

public class _91_解码方法 {
	 public int numDecodings(String s) {
		 
		 char[] str = s.toCharArray();
		 return Process(str,0);
	 }

	private int Process(char[] str, int index) {
		// TODO Auto-generated method stub
		
		if(index==str.length) return 1; // 找到一种符合题意的方案，返回一
		if(str[index]=='0') return 0;  // "06" 返回0
		int ways = Process(str, index+1);
		
		if(index+1==str.length) return ways;
		int num = (str[index]-'0')*10 + str[index+1]-'0';
		if(num<=26) ways+=Process(str, index+2);
		return ways;
	}
	
	
     public int numDecodings2(String s) {
		 
    	char[] str = s.toCharArray();
 		int N = str.length;
 		// dp[i] -> process(str, index)返回值 index 0 ~ N
 		int[] dp = new int[N + 1];
 		dp[N] = 1;

 		// dp依次填好 dp[i] dp[i+1] dp[i+2]
 		for (int i = N - 1; i >= 0; i--) {
 			if (str[i] != '0') {
 				dp[i] = dp[i + 1];
 				if (i + 1 == str.length) {
 					continue;
 				}
 				int num = (str[i] - '0') * 10 + str[i + 1] - '0';
 				if (num <= 26) {
 					dp[i] += dp[i + 2];
 				}
 			}
 		}
 		return dp[0];
 		
     }
}
