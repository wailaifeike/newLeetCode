package 数组;

/*
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

 
示例:
输入: [1,2,3,4]
输出: [24,12,8,6]

提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/product-of-array-except-self
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _238_除自身以外数组的乘积 {
	 public static int[] productExceptSelf(int[] nums) {
		 int[] dpR = new int[nums.length];
		 int[] dpL = new int[nums.length];
		 dpL[0] = 1;
		 dpR[nums.length-1] = 1;
		 int sum1 = 1,sum2 = 1;
		 for (int i = 1; i < nums.length; i++) {
			sum1 *=nums[i];
		 }
		 for (int i = 0; i < nums.length-1; i++) {
				sum2 *=nums[i];
		 }
		 dpR[0] = sum1;
		 dpL[nums.length-1] = sum2;
		 
		 for (int i = 1; i < nums.length-1; i++) {
			 dpL[i] = dpL[i-1] * nums[i-1]; 
		 }
		 
		 for (int j = nums.length-2; j >=1; j--) {
			 dpR[j] = dpR[j+1] * nums[j+1];
		 }
		 int[] new_arr = new int[nums.length];
		 for (int i = 0; i < new_arr.length; i++) {
			new_arr[i] = dpL[i]*dpR[i];
		 }
		 
		 return new_arr;
	 }
	 
	 public static void main(String[] args) {
		int[] nums = new int[]{4,2,3,4};
		productExceptSelf(nums);
	}
}
