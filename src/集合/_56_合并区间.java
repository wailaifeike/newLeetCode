package 集合;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 
 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals

示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].


 * 
 * */
public class _56_合并区间 {
	 public static int[][] merge(int[][] intervals) {
		 //先对intervals第一个元素排序
		 Arrays.sort(intervals, new Comparator<int[]>() {
			 public int compare(int[] a, int[] b){
                 return a[0] - b[0];
             }
		 });
		 
		 int[][] res = new int[intervals.length][2];
		 
		 return Process(intervals,res);
	 }
	 
	 
	 private static int[][]  Process(int[][] intervals, int[][] res) {
		    int index = 0;
			for (int i = 0; i < intervals.length; i++) {
				//若是第一个区间，或者当前区间的起始位置 > 结果数组res中最后区间的终止位置
				//（注意，结果数组res中最后区间的下标是 index-1）
				//System.out.println("intervals[i]"+intervals[i][0]);
	            //则不需要将当前区间合并到上一个区间，那么当前区间可以赋值给ret，作为一个新的“合并基底”，将后面满足条件的区间向这个基底合并
				if(i==0 || intervals[i][0]>res[index-1][1])
	                res[index++] = intervals[i];//同时将index+1
	            else
	                //否则，需要将当前区间合并到结果数组res的最后区间（即res中下标为index-1的区间），此时index不需要变化
	                //此时需要改变 ret[index][1]，即ret[index] 数组的右边界可能扩展
	                res[index-1][1] = Math.max(res[index-1][1] , intervals[i][1]);
			}
			
	     //res数组中实际上只有 index 个数组有效，其他都是 (0 , 0)，我们原先设置res长度为 intervals.length，需要将有效部分复制返回！
		  return Arrays.copyOf(res , index);
		
	}


	//for test
	 public static void main(String[] args) {
		 int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
		 int[][] brr = merge(arr);
      	 System.out.println(brr.length);
		 for (int i = 0; i < brr.length; i++) {
			System.out.println(brr[i][0]+"-->"+brr[i][1]);
		}
	 }
}
