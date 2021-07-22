package 回溯;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.naming.ldap.SortControl;

/*
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets-ii
 
 * */
public class _90_子集 {
	List<List<Integer>> list = new LinkedList<List<Integer>>();
	List<Integer> path = new LinkedList<Integer>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if(nums.length==0) return new LinkedList<List<Integer>>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backTravel(nums,0,used);
		return list;
    }
	
	private void backTravel(int[] nums, int startIndex,boolean[] used) {
		
		list.add(new LinkedList<Integer>(path));
		for(int i= startIndex;i<nums.length;i++){
			if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false) continue;
			path.add(nums[i]);
			used[i] = true;
			backTravel(nums, i+1, used);
			used[i] = false;
			path.remove(path.size()-1);
		}
	}
	
	   public List<List<Integer>> subsetsWithDup2(int[] nums) {
		    List<List<Integer>> ans = new ArrayList<List<Integer>>();
		    Arrays.sort(nums); //排序
		    getAns(nums, 0, new ArrayList<Integer>(), ans);
		    return ans;
		}

		private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
		    ans.add(new ArrayList<Integer>(temp));
		    for (int i = start; i < nums.length; i++) {
		        //和上个数字相等就跳过
		        if (i > start && nums[i] == nums[i - 1]) {
		            continue;
		        }
		        temp.add(nums[i]);
		        getAns(nums, i + 1, temp, ans);
		        temp.remove(temp.size() - 1);
		    }
		}

}
