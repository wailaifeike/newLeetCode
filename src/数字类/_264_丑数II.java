package 数字类;

/*
 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
丑数 就是只包含质因数 2、3 和/或 5 的正整数。
示例 1：
输入：n = 10
输出：12
解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ugly-number-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */
public class _264_丑数II {
	public int nthUglyNumber(int n) {
		int[] dp = new int[n+1];
		dp[1] = 1;
		int p2=1, p3=1,p5=1;
		for(int i=2;i<=n;i++) {
			int num2 = dp[p2]*2;
			int num3 = dp[p3]*3;
			int num5 = dp[p5]*5;
			dp[i] = Math.min(Math.min(num2, num3), num5);
			if(dp[i]==num2) p2++;
			if(dp[i]==num3) p3++;
			if(dp[i]==num5) p5++;
		}
		return dp[n];
    }
}
