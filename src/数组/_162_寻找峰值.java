package 数组;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 峰值元素是指其值大于左右相邻值的元素。
给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
可以假设 nums[-1] = nums[n] = -∞ 。
示例 1：
输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-peak-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 进阶：你可以实现时间复杂度为 O(logN) 的解决方案吗？
 * 如果此时某个数字小于前面那个数字，说明前面数字就是一个局部峰值
 **/
public class _162_寻找峰值 {
	 public int findPeakElement(int[] nums) {
		   int left = 0, right = nums.length - 1;
	        while (left < right) {
	            int mid = left + (right - left) / 2;
	            if (nums[mid] < nums[mid + 1]) left = mid + 1;
	            else right = mid;
	        }
	        return right;
	 }
	 
	 public int findPeakElement2(int[] nums) {
		 //如果此时某个数字小于前面那个数字，说明前面数字就是一个局部峰值
		  for (int i = 1; i < nums.length; ++i) {
	         if (nums[i] < nums[i - 1]) return i - 1;
	     }
	     return nums.length - 1;
	 }
	 

}
