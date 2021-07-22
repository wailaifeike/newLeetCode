package 数字类;

/*
 * 编写一段程序来查找第 n 个超级丑数。
超级丑数是指其所有质因数都是长度为 k的质数列表 primes 中的正整数。

示例:

输入: n = 12, primes = [2,7,13,19]
输出: 32 
解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/super-ugly-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class _313_超级丑数 {
	public static int nthSuperUglyNumber(int n, int[] primes) {		
		int[] dp = new int[n+1];
		dp[1] = 1;
		int len = primes.length;
		int[] p = new int[len+1];
		for (int i = 1; i < p.length; i++) {
			p[i] = 1;
		}
		int[] nums = new int[len+1];
		int p2=1, p7=1,p13=1,p19=1;
		for(int i=2;i<=n;i++) {
			int min_num = Integer.MAX_VALUE;
			for(int j=1;j<nums.length;j++) {
				nums[j] = dp[p[j]]*primes[j-1];
				if(nums[j]<min_num) min_num = nums[j];
			}
			
			dp[i] = min_num;
			for(int k=1;k<p.length;k++) {
				if(nums[k]==dp[i]) {
					p[k]++;
				}
			}
		}
		return dp[n];
    }
	
	public static void main(String[] args) {
		int[] primes = {2,7,13,19};
		int res = nthSuperUglyNumber(12,primes);
		System.out.println(res);
	}
}
