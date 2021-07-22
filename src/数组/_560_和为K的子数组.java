package 数组;

import java.util.HashMap;

/*
 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 
示例 1 :
输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * */
public class _560_和为K的子数组 {
	public static int subarraySum(int[] nums, int k) {
		    int count = 0;
	        for (int start = 0; start < nums.length; ++start) {
	            int sum = 0;
	            for (int end = start; end >= 0; --end) {
	                sum += nums[end];
	                if (sum == k) {
	                    count++;
	                }
	            }
	        }
	        return count;
    }
	

	    public int subarraySum2(int[] nums, int k) {
	        int count = 0, pre = 0;
	        HashMap < Integer, Integer > mp = new HashMap < > ();
	        mp.put(0, 1);
	        for (int i = 0; i < nums.length; i++) {
	            pre += nums[i];
	            if (mp.containsKey(pre - k)) {
	                count += mp.get(pre - k);
	            }
	            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
	        }
	        return count;
	    }


	
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1};
		int k = 2;
		System.out.println(subarraySum(nums,2));
	}
}
