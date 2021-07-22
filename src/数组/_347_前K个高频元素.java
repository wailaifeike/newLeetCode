package 数组;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/top-k-frequent-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _347_前K个高频元素 {
	 public static int[] topKFrequent(int[] nums, int k) {
		 HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>();
		 for (int num:nums) {
			map.put(num, map.getOrDefault(num, 0)+1);
			
		 }
		 
		 //建立一个堆结构,自定义比较器
		 PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
				 new Comparator<int[]>() {
					 public int compare(int[] a,int[] b) {
						return a[1]-b[1];
					 }
				 }
				 
	     );
		 
		 for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
			 int key = entry.getKey();
			 int count = entry.getValue();
//			 System.out.println(key+"-->"+count);
			 if(queue.size()==k){
				int[] tmp = queue.peek();
				if(tmp[1]<count){
					queue.poll(); // 队头出列，弹出
					queue.offer(new int[]{key,count});
				}
			 }else {
				 queue.offer(new int[]{key,count});
			 }

		 }
		
		 int[] ans = new int[k];
		 for (int i = 0; i < ans.length; i++) {
			ans[i] = queue.poll()[0];
		}
		 
		 return ans;
	 }
	 
	 public static void main(String[] args) {
		int[] arr = new int[]{1,1,1,2,2,3};
		int[] ret = topKFrequent(arr, 2);
		for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i]);
		}
	}
}
