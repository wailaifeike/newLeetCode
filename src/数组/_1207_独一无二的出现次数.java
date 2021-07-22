package 数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。

如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

 

示例 1：

输入：arr = [1,2,2,1,1,3]
输出：true
解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 * 
 * */
public class _1207_独一无二的出现次数 {
     public boolean uniqueOccurrences(int[] arr) {
         Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
         for (int i = 0; i < arr.length; i++) {
			map1.put(arr[i], map1.getOrDefault(arr[i], 0)+1);
		 }
         
         Set<Integer> set = new HashSet<Integer>();
         for (Integer i : map1.keySet()) {
             if (!set.add(map1.get(i))) { // 有
                 return false;
             }
         }
    	 return true;
     }
}
