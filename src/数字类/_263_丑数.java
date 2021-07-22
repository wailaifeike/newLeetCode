package 数字类;

/*
 * 
 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
示例:
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/chou-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
丑数 就是只包含质因数 2、3 和/或 5 的正整数。
示例 1：

输入：n = 6
输出：true
解释：6 = 2 × 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ugly-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class _263_丑数 {
	 public boolean isUgly(int n) {
		 if(n<=0) return false;
		 while(n%2==0) n/=2;
		 while(n%3==0) n/=3;
		 while(n%5==0) n/=5;
		 return n==1;
	 }
}
