package 动态规划;


/*
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标。

示例 1：

输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _55_跳跃游戏 {
	 public static boolean canJump(int[] nums) {
		 
//		 boolean flag = Process(nums,0);
//		 return flag;
		 return false;
	 }
	 
	 public static boolean canJump2(int[] nums) {
			if (nums == null || nums.length < 2) {
				return true;
			}
			int max = nums[0];
			for (int i = 1; i < nums.length; i++) {
//				if (max >= nums.length - 1) {
//					return true;
//				}
				if (i > max) {
					return false;
				}
				max = Math.max(max, i + nums[i]);
			}
			return true;
		}
	 //遍历数组中每一个数字，如果当前坐标大于 reach 或者 reach 已经抵达最后一个位置则跳出循环，
	 //否则就更新 reach 的值为其和 i + nums[i] 中的较大值，其中 i + nums[i] 表示当前位置能到达的最大位置
	 private boolean canJump3(int[] nums) {
		int reach = 0;// 表示最远能到达的位置
		for (int i = 0; i < nums.length; i++) {
			if(i>reach||reach>=nums.length-1) break;
			reach = Math.max(reach, i+nums[i]);
		}
		
		return reach>=nums.length-1;
	 }
	public static void main(String[] args) {
		int[] arr = new int[]{3,2,1,0,4};
		System.out.println(canJump(arr));;
	}
}
