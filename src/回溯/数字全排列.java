package 回溯;

import java.util.ArrayList;

import java.util.List;


public class 数字全排列 {
	   List<List<Integer>> list = new ArrayList<List<Integer>>();
	   List<Integer> result = new ArrayList<Integer>();
		public  List<List<Integer>> permute(int[] nums) {
			if(nums==null) return new ArrayList<List<Integer>>();
			generatePermutation(nums, 0, list);
			return list;
	    }
		
		public  void generatePermutation(int[] nums,int index,List<List<Integer>> list) {
			if(index==nums.length) {
			List<Integer> list1 = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				list1.add(nums[i]);
			}
			list.add(list1);
	        return;
			}
			
			for (int i = index; i < nums.length; i++) {
				swap(nums, index, i);
				generatePermutation(nums, index + 1, list);
				swap(nums, index, i);
			}
		}

		private  void swap(int[] nums, int j, int i) {
			// TODO Auto-generated method stub
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
		
		
		public static void main(String[] args) {
			int[] nums = new int[]{1,2,3};
			//List<List<Integer>> aa = permute(nums);
			
			//System.out.println(aa);
		}
}
