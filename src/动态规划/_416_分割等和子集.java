package 动态规划;

import java.util.Iterator;

/*
 * 
 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _416_分割等和子集 {
	public boolean canPartition(int[] nums) {
		if(nums.length<=1) return false;
		if(nums.length==2) return nums[0]==nums[1];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
		}
		if((sum&1)==1) return false; // 奇数直接为false
		int target = sum/2;
		 boolean[] dp = new boolean[target+1];
		 dp[0] = true;
		 for (int num:nums) {
			 for (int i = target; i>=num; i--) {
				dp[i] = dp[i]||dp[i-num];
			}
		 }
		return dp[target];
    }
}
