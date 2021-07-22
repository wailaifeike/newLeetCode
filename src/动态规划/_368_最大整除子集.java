package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，
 * 子集中每一元素对 (answer[i], answer[j]) 都应当满足：
answer[i] % answer[j] == 0 ，或
answer[j] % answer[i] == 0
如果存在多个有效解子集，返回其中任何一个均可。


示例 1：
输入：nums = [1,2,3]
输出：[1,2]
解释：[1,3] 也会被视为正确答案。
示例 2：

输入：nums = [1,2,4,8]
输出：[1,2,4,8]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-divisible-subset
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */


public class _368_最大整除子集 {
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		int[] dp = new int[nums.length];
		int[] last = new int[nums.length];
		int mx_len = 0;
		int mx_len_index = 0;
		for (int i= nums.length-1; i>=0; i--) {
			for (int j = i; j < nums.length; j++) {
				if(nums[j]%nums[i]==0&&dp[i]<dp[j]+1) {
					dp[i]=dp[j]+1;
					last[i] = j;
					if(mx_len<dp[i]) {
						mx_len = dp[i];
						mx_len_index = i;
					}
				}
			}
		}
		
		for (int i = 0; i < mx_len; i++) {
			list.add(nums[mx_len_index]);
			mx_len_index = last[mx_len_index];
			
		}
		return list;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,4,7,8,9,12,16,18};
		System.out.println(largestDivisibleSubset(nums));
	}
}
