package 排序类;

import java.nio.Buffer;

/*
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 

示例 1：

输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
示例 2：

输入：nums = [2,0,1]
输出：[0,1,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _75_颜色分类 {
	public static void sortColors(int[] nums) {
		int red_index = 0;
		int white_index = 0;
		int blue_index = 0;
		int[] red = new int[nums.length];
		int[] white = new int[nums.length];
		int[] blue = new int[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0){ // 红色
				red[red_index++] = nums[i];
			}else if (nums[i]==1) {
				white[white_index++] = nums[i];
			}else {
				blue[blue_index++] = nums[i];
			}
		}
		for (int i = 0; i < red_index; i++) {
			nums[i] = red[i];
		}
		for (int i = 0; i < white_index; i++) {
			nums[red_index++] = white[i];
		}
		for (int i = 0; i < blue_index; i++) {
			nums[red_index++] = blue[i];
		}
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{2,0,1};
		sortColors(nums);
	}
}
