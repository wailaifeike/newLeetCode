package 数字类;

/*
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。

 

示例 1：

输入：nums = [1,3,4,2,2]
输出：2
示例 2：

输入：nums = [3,1,3,4,2]
输出：3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-duplicate-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _287_寻找重复数 {
	public static int findDuplicate(int[] nums) {
		int start = 1, end = nums.length - 1;
        int mid = (start + end) / 2;
        while (start <= end){
            int count = 0;
            for(int num: nums){
                if(num < mid)
                    count += 1;
                  
            }
            if( count >= mid)
                end = mid - 1;
            else
                start = mid + 1;
            mid = (start + end) / 2;
        }

        return mid;
	
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,1,3,4,2};
		
		System.out.println(findDuplicate(arr));
	}
}
