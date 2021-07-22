package 堆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 
 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k
定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。

示例 1:
输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
输出: [1,2],[1,4],[1,6]
解释: 返回序列中的前 3 对数：
     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _373_查找和最小的K对数字 {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2)->{
            return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
        });
        //取最小值是为了防止两个数组一个比较少的时候【1】  【1,2,3】
        for(int i = 0; i < Math.min(nums1.length, k); i++){
            for(int j = 0; j < Math.min(nums2.length, k); j++){
                if(queue.size() < k) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums1[i]);
                    pair.add(nums2[j]);
                    queue.add(pair);
                }else {
                    int top = queue.peek().get(0) + queue.peek().get(1);
                    //大于K就出队列 
                    if(top > nums1[i]+nums2[j]){
                        List<Integer> pair = new ArrayList<>();
                        queue.poll();
                        pair.add(nums1[i]);
                        pair.add(nums2[j]);
                        queue.add(pair);
                    }
                }
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for(int i =0; i < k && !queue.isEmpty(); i++){
            res.add(queue.poll());
        }
        return res;
    }
	
	public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums1.length, m = nums2.length;
        if(n == 0 || m == 0) return res;
        // 利用一个数组来保存nums1中每个元素对应的最小组合的nums2下标，初始值为0，因为刚开始每个元素对应的最小组合肯定是对面的第一个元素
        int[] f = new int[n];

        // 外层最多遍历k次，获取前k个最小值
        while(res.size() < k) {
            int cur = 0;
            // 遍历每个nums1元素对应nums2最小可用组合，并获取最小组合
            for(int i = 1; i < n; i++) {
                // 当前i位置可用组合已经用完了
                if(f[i] == m) continue;
                // 比较获取最小的组合
                if(f[cur] == m || nums1[cur] + nums2[f[cur]] > nums1[i] + nums2[f[i]]) {
                    cur = i;
                }
            }
            // 所有的组合都用完了，就跳出循环
            if(f[cur] == m) break;
            // 答案中添加当前组合
            res.add(Arrays.asList(nums1[cur], nums2[f[cur]]));
            // 当前组合中nums1元素对应的nums2元素下标加一，这样就不会重复用到之前的组合
            f[cur] ++;
        }

        return res;

    }

}
