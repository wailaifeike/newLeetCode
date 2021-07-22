package 位运算;

/*
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例 1：

输入：[3,2,3]
输出：3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class _169_多数元素 {
	 //摩尔投票法 Moore Voting，需要 O(n) 的时间和 O(1) 的空间 
	 public int majorityElement(int[] nums) {
		 int res = 0;
		 int count = 0; // 计数器
		 for(int num:nums) {
			 if(count==0) {
				 res = num;
				 count++;
			 }else if(num==res) {
				 count++;
			 }else {
				 count--;
			}
		 }
		 return res;
	 }
}
