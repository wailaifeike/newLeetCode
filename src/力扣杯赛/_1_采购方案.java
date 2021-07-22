package 力扣杯赛;

import java.util.Arrays;

/*
 * https://leetcode-cn.com/contest/season/2021-spring/problems/4xy4Wx/
小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。

注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
示例 1：
输入：nums = [2,5,3,5], target = 6
输出：1
解释：预算内仅能购买 nums[0] 与 nums[2]。
 * 
 * */
public class _1_采购方案 {
	public static int purchasePlans(int[] nums, int target) {
		
		
		return Process(nums,target,0,0,0);
    }

	private static int Process(int[] nums, int target, int count,int sum,int index) {
		if(target<0) return 0;
		if(count==2 && target>=0) return 1;
		
		for (int i = index; i < nums.length; i++) {
			sum +=  Process(nums, target-nums[i], count+1, sum, index+1);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{2,2,1,9};
		int target = 10;
		int count = 0;
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length -1;
		while (left<right) {
			if(arr[left] +arr[right] > target) right--;
			else {
				count += right -left ;
				left++;
			}
			
		}
		System.out.println(count%1000000007);
	}
}
