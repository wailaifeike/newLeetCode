package 数组;
//https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
public class _81_搜索旋转排序数组II {
	public static boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while (left<=right) {
			if(nums[left]==target) return true;
			if(nums[right]==target) return true;
			if(target>nums[left]) left++;
			else if(nums[left]>target&&target>nums[right]){
				left++;
			}

			if(target<nums[right]) right--;
			
		}
		
		return false;
    }
	
	public static boolean search2(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while (left<=right) {
			int mid = (left+right)/2;
			if(nums[mid]==target) return true;
			
			if(nums[mid]<nums[right]){
				if(nums[mid]<target&&target<=nums[right]) left = mid+1;
				else {
					right = mid -1;
				}
			}else if(nums[mid]>nums[right]){
				if(nums[left]<=target&&target<nums[mid]) right = mid-1;
				else {
					left = mid + 1;
				}
			}else {
				right--;
			}
			
		}
		
		return false;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1
				};
		int target = 2;
		
		System.out.println(search2(nums,target));
		
	}
}
