package 数组;

/*
 * 
 给你一个整数数组 nums,请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）,并返回该子数组所对应的乘积。

示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

示例 2:
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * */
public class _152_乘积最大子数组 {
	public static int maxProduct(int[] nums) {
		int ans = nums[0];
		int min = nums[0];
		int max = nums[0];
		// [0]   
		for (int i = 1; i < nums.length; i++) {
			int curmin = Math.min(nums[i], Math.min(min * nums[i], max * nums[i]));
			int curmax = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
			min = curmin;
			max = curmax;
			ans  = Math.max(ans, max);
		}
		return ans;
    }
	
	
	public static int maxProduct3(int[] nums) {
		    int res = nums[0];
	        int[] f = new int[nums.length];
	        int[] g = new int[nums.length];
	        f[0] = nums[0];
	        g[0] = nums[0];
	        for (int i = 1; i < nums.length; ++i) {
	            f[i] = Math.max(Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
	            g[i] = Math.min(Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
	            res = Math.max(res, f[i]);
	        }
	        return res;
    }
	
	public static int maxProduct2(int[] nums) {
		int N = nums.length;
		// dp[i] 含义：子数组必须以i结尾的时候，所有可以得到的子数组中，最大累加和是多少？
		int[] dp = new int[N];
		dp[0] = nums[0];
		int max = nums[0];
		for (int i = 1; i < N; i++) {
//			int p1 = nums[i];
//			int p2 = nums[i] * dp[i - 1];
			dp[i] = Math.max(dp[i-1], dp[i-1]*nums[i]);
			//dp[i]  = Math.max(dp[i-1], dp[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
    }
	
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{2,3,-2,4};
		int result = maxProduct2(arr);
		System.out.println(result);
	}
}
