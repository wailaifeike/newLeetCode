package 数字类;

/*
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。

示例 1：
输入：c = 5
输出：true
解释：1 * 1 + 2 * 2 = 5

示例 2：
输入：c = 3
输出：false

示例 3：
输入：c = 4
输出：true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-square-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _633_平方数之和 {
	 public boolean judgeSquareSum(int c) {
		 
		for(int i = (int) Math.sqrt(c);i>=0;i++) {
			if(i*i == c) return true;
			int d = c -i*i;
			int t = (int) Math.sqrt(d);
			if(t*t == d) return true;
		} 
		 
		 return false;
	 }
	 
	 public boolean judgeSquareSum2(int c) {
		  long a = 0, b = (long) Math.sqrt(c);
	        while (a <= b) {
	            if (a * a + b * b == c) return true;
	            else if (a * a + b * b < c) ++a;
	            else --b;
	        }
	        return false;
		 }
}
