package 数字类;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。

示例 1：
输入：[3,2,3]
输出：[3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */
public class _229_求众数II {
	 public List<Integer> majorityElement(int[] nums) {
		 List<Integer> list = new LinkedList<Integer>();
		 int len = nums.length;
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		 for(int num:nums) {
			 map.put(num, map.getOrDefault(num, 0)+1);
		 }
		 
		 for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			 int key = entry.getKey();
			 int value = entry.getValue();
			 if(value>len/3) {
				 list.add(key);
			 }
		 }
		 return list;
	 }
	 
	 
	 public List<Integer> majorityElement2(int[] nums) {
		 //摩尔投票算法 核心是最多有两个候选者
		 List<Integer> list = new LinkedList<Integer>();
		 
		 int c1 = 0,c2 = 0;
		 int count1 = 0,count2= 0;
		 int len = nums.length;
		 
		 // 筛选俩个候选数C1，C2
		 for(int num:nums) {
			if(num==c1) {
				count1++;
			}else if (num==c2) {
				count2++;
			}else if (count1==0) {
				c1 = num;
				count1 = 1;
			}else if (count2==0) {
				c2 = num;
				count2 = 1;
			}else {
				count1--;
				count2--;
			}  
		 }		 
		 //验证C1，C2
		 int a=0,b = 0;
		 for(int num:nums) {
			 if(num==c1) {
				 a++;
			 }else if(num==c2) {
				 b++;
			 }
		 }		 
		 if(a>len/3) list.add(c1);
		 if(b>len/3) list.add(c2);
		 return list;
	 }
}
