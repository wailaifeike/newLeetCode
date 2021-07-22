package 数组;

/*
 
 定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]，
并返回其长度。如果不存在符合条件的子数组，返回 0 。
示例 1：
输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 */
public class _209_长度最小的子数组 {
	public int minSubArrayLen(int target, int[] nums) {
		if(nums.length==0) return 0;
        int left = 0, right = 0, sum = 0, len = nums.length, res = len + 1;
        while (right < len) {
            while (sum < target && right < len) {
                sum += nums[right++];
            }
            while (sum >= target) {
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }
        
        return res == len + 1 ? 0 : res;
		
    }
}
