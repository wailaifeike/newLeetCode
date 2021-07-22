package 数字类;

import java.util.HashMap;
import java.util.Map;

/*
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _454_四数相加II {
	 public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 
		int count = 0;
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				map.put(nums1[i]+nums2[j], map.getOrDefault(nums1[i]+nums2[j], 0)+1);
			}
		}
		
		
		for(Map.Entry<Integer, Integer> entry:map.entrySet()){
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
		
		for (int i = 0; i < nums3.length; i++) {
			for (int j = 0; j < nums4.length; j++) {
				  int target = -1 * (nums3[i] + nums4[j]);
				  count += map.getOrDefault(target, 0);
			}
		}
		 return count;
	 }
	 
	 public static void main(String[] args) {
		int[] nums1 = new int[]{1,2};
		int[] nums2 = new int[]{-2,-1};
		int[] nums3 = new int[]{-1, 2};
		int[] nums4 = new int[]{0, 2};
		System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
		
	 }
}
