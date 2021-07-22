package 数字类;

import java.util.HashMap;
import java.util.Stack;

/*
给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-greater-element-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _496_下一个更大元素I {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		Stack<Integer> stack = new Stack<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num:nums2) {
			while(!stack.isEmpty()&&stack.peek()<num) {
				map.put(stack.peek(), num);
				stack.pop();
			}
			stack.push(num);
		}
		
		for(int i=0;i<nums1.length;i++) {
			res[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]):-1;
		}
		return res;
    }
}
