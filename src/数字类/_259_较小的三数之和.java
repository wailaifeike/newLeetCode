package 数字类;

import java.util.Arrays;

public class _259_较小的三数之和 {
	public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;
        int res = 0, n = nums.length;
        //sort(nums.begin(), nums.end());
        
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; ++i) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    res += right - left;
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return res;
    }
}
