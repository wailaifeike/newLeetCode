package 数组;

/*
 * 
给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

请你找出符合题意的 最短 子数组，并输出它的长度。

 

示例 1：
输入：nums = [2,6,4,8,10,9,15]
输出：5
解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
示例 2：


输入：nums = [1,2,3,4]
输出：0
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */

public class _581_最短无序连续子数组 {
	 public int findUnsortedSubarray(int[] nums) {
		 int start = -1;
		 int res = 0;
		 for (int i = 1; i < nums.length; i++) {
			if(nums[i]<nums[i-1]) {
				int j = i;
				while (nums[j]<nums[j-1]&&j>=1) {
					swap(nums,j,j-1);
					j--;
					
				}
				
				if(start==-1||j<start) start = j;
				
				res = i-start+1;
			}
		}
		 return res;
	 }

	  private void swap(int[] nums, int j, int i) {
			int tmp = nums[i];
			nums[i]=  nums[j];
			nums[j] = tmp;
				
	}
}
