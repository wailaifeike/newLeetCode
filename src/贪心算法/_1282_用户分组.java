package 贪心算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，
 * 其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-the-people-given-the-group-size-they-belong-to
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示例 1：

输入：groupSizes = [3,3,3,3,3,1,3]
输出：[[5],[0,1,2],[3,4,6]]
解释： 
其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]
 */
public class _1282_用户分组 {
	 public List<List<Integer>> groupThePeople(int[] groupSizes) {
		//key:对应分组大小 value=对应分组大小的id
	        Map<Integer, List<Integer>> map = new HashMap<>();
	        List<List<Integer>> res = new ArrayList<>();
	        int size = groupSizes.length;
	        for(int i=0; i<size; i++){
	            //当前用户所在分组大小
	            int group = groupSizes[i];
	            //当前分组大小未创建
	            if(map.get(group)==null){
	                //添加list
	                map.put(group, new ArrayList<>());
	                //当前用户id加入对应分组大小的list
	                map.get(group).add(i);
	            }else if(map.get(group).size()==group){
	                //当前分组大小已满,
	                //比如分组大小为3, 但是之前已经有3个,
	                //将之前已经满了的加入res
	                res.add(map.get(group));
	                //将对应的分组大小添加新的list
	                map.put(group, new ArrayList<>());
	                //当前id加入list
	                map.get(group).add(i);
	            }else{
	                //可以直接加入
	                map.get(group).add(i);
	            }
	        }
	        //遍历剩余已经满了但是还没加入res的分组大小
	        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
	            if(!entry.getValue().isEmpty()){
	                res.add(entry.getValue());
	            }
	        }
	        
	        return res;
	 }
}
