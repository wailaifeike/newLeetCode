package 位运算;

/*
 *给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。

 

进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？

 

示例 1：
输入：nums = [1,2,1,3,2,5]
输出：[3,5]
解释：[5, 3] 也是有效的答案。

示例 2：
输入：nums = [-1,0]
输出：[-1,0]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/single-number-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 * */
public class _260_只出现一次的数III {
	
	//分组异或
	 public static int[] singleNumber(int[] nums) {
		 int x = 0;
		 for(int num:nums) {
			 x^=num;
		 }
		 // 找到一个位为1的位
		 
		 int bt = 1;
		 
		 while((x&bt)==0) {
			 bt<<=1;
		 }
		 
		 int res1 = 0;
		 int res2 = 0;
		 
		 //int[] res = new int[2];
		 
		 for(int num:nums) {
			if((bt&num)!=0) {
				res1^=num;
			}else {
				res2^=num;
			}
		 }
		 
		 return new int[] {res1,res2};
	 }
	 
	 public static void main(String[] args) {
		 int[] nums = new int[] {1,2,1,3,2,5};
		 int[] ret = singleNumber(nums);
		 for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i]);
		}
	}
}
