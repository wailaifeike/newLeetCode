package 数组;
/*

 链接：https://leetcode-cn.com/problems/maximum-subarray
 
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为6 。

示例 2：
输入：nums = [1]
输出：1
来源：力扣（LeetCode）

 
 * */
public class _53_最大子序和_最大子数组和 {
	 public int maxSubArray(int[] nums) {
		 
		    int N = nums.length;
			// dp[i] 含义：子数组必须以i结尾的时候，所有可以得到的子数组中，最大累加和是多少？
			int[] dp = new int[N];
			dp[0] = nums[0];
			int max = nums[0];
			for (int i = 1; i < N; i++) {
				int p1 = nums[i];
				int p2 = nums[i] + dp[i - 1];
				dp[i] = Math.max(p1, p2);
				max = Math.max(max, dp[i]);
			}
			return max;
	 }
}
