package 数组;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。

你可以搭配 任意 两道餐品做一顿大餐。

给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。
结果需要对 109 + 7 取余。
注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-good-meals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 输入：deliciousness = [1,3,5,7,9]
输出：4
解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-good-meals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * 
 **/
public class _1711_大餐计数 {
	 public int countPairs(int[] deliciousness) {
		    //记录所有数出现的次数
	        HashMap<Integer , Integer> map = new HashMap<>();
	        //记录已经参与过计算的数
	        HashSet<Integer> set = new HashSet<>();
	        //存2的0次方到21次方
	        int[] nums = new int[22];
	        nums[0] = 1;
	        for(int i = 1 ; i < 22 ; i++){
	            nums[i] = nums[i-1] << 1;
	        }
	        //数字以及对应个数存入map
	        for(int i : deliciousness){
	            map.put(i , map.getOrDefault(i , 0) + 1);
	        }
	        int ans = 0;
	        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
	            //去除当前的数以及它在数组中对应的个数
	            int key = entry.getKey();
	            int value = entry.getValue();
	            //判断在2的0次方到21次方判断是否有合适的数
	            for(int i : nums){
	                int k = i - key;
	                //无，直接跳过
	                if(!map.containsKey(k)) continue;
	                //k已经参与过计算了，不能重复计算，跳过
	                if(set.contains(k)) continue;
	                int t = map.get(k);
	                if(k == key){
	                    //当本身与本身相加满足条件时，得到的个数时(n*(n-1))/2
	                    //注意转为long防止越界
	                    long a = ((long)t*(long)(t-1))/2;
	                    a %= 1000000007;
	                    ans += (int)a;
	                }else{
	                    //不是自身时，直接相乘即可
	                    long a = (long)value*(long)t;
	                    a %= 1000000007;
	                    ans += (int)a;
	                }
	                //key参与过计算，需要屏蔽
	                set.add(key);
	                ans %= 1000000007;
	            }
	        }
	        return ans;
	 }
}
