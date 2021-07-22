package others;

import java.util.HashMap;
import java.util.Map;

/*
在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
返回重复了 N 次的那个元素。
示例 1：
输入：[1,2,3,3]
输出：3

示例 2：
输入：[2,1,2,5,3,2]
输出：2

示例 3：
输入：[5,1,5,2,5,3,5,4]
输出：5
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */
public class _961_重复N次的元素 {
	 public int repeatedNTimes(int[] nums) {
		 
		 Map<Integer, Integer> count = new HashMap<Integer, Integer>();
	        for (int x: nums) {
	            count.put(x, count.getOrDefault(x, 0) + 1);
	        }

	        for (int k: count.keySet())
	            if (count.get(k) > 1)
	                return k;

	        throw null;

	 }
}
