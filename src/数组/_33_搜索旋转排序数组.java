package 数组;

/*
 * 
 * 示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）
上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 
 * 
 * */
public class _33_搜索旋转排序数组 {

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while (left<=right) {
			if(nums[left]==target) return left;
			if(nums[right]==target) return right;
			if(target>nums[left]) left++;
			else if(nums[left]>target&&target>nums[right]){
				left++;
			}

			if(target<nums[right]) right--;
			
		}
		
		return -1;
    }
	
	
	//二分查找
	
	public static int search2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) { // 有序部分
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // 无序部分
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
	
	public static boolean search3(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] == target ? true : false;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] <= nums[r]) { // 有序部分
                if (nums[mid] <= target && target < nums[r]) {
                    r = mid + 1;
                } else {
                    l = mid -1 ;
                }
            } else { // 无序部分
                if (nums[0] < target && target <= nums[mid]) {
                    l = mid - 1;
                } else {
                    r = mid + 1;
                }
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{2,5,6,0,0,1,2};
		int target = 3;
		
		System.out.println(search(nums,target));
		
	}
	
		
}
