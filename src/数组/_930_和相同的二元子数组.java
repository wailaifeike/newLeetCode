package 数组;

import java.util.HashMap;
import java.util.Map;

/*
给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
子数组 是数组的一段连续部分。
示例 1：
输入：nums = [1,0,1,0,1], goal = 2
输出：4
解释：
如下面黑体所示，有 4 个满足题目要求的子数组：
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _930_和相同的二元子数组 {
	public int numSubarraysWithSum(int[] nums, int goal) {
		int res = 0, curSum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
        for (int num : nums) {
            curSum += num;
            if(map.containsKey(curSum-goal))res += map.get(curSum-goal);
            map.put(curSum, map.getOrDefault(curSum, 0)+1);
        }
        return res;
		
    }
	
	
	//双指针+滑动窗口
	
	public int numSubarraysWithSum2(int[] nums, int goal) {
		int res = 0, sum = 0, left = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            while (left < i && sum > goal) sum -= nums[left++];
            if (sum < goal) continue;
            if (sum == goal) ++res;
            for (int j = left; j < i && nums[j] == 0; ++j) {
                ++res;
            }
        }
        return res;
		
    }
}
