package 数组;

import java.util.Stack;
/*
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4
 * int i = 0;
 * for(int j = 1; j < nums.length; j++){
 * 		if(nums[j]!=nums[i]){
 * 			i++;
 * 			nums[i] = nums[j];
 * 		}
 * }
 * 
 * return i+1;
 * 
 * 
 * */
public class _26_删除排序数组中的重复项 {
	 public int removeDuplicates(int[] nums) {
		 Stack<Integer> stack = new Stack<Integer>();
		 
		 for (int i = 0; i < nums.length; i++) {
			 if(stack.isEmpty()){
				 stack.add(nums[0]);
			 }else {
				if(nums[i]!=stack.peek()) stack.add(nums[i]);
			}
		 }
		 
		 int len = stack.size();
		 for (int i = 1; i <=len; i++) {
			 nums[len-i] = stack.pop();
		}
		 
		 for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
				 
		 
		 return len;
	 }

}
