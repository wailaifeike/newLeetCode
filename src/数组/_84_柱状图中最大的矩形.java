package 数组;

import java.util.Arrays;
import java.util.Stack;

/*
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 
 * */
public class _84_柱状图中最大的矩形 {
	
	 //局部峰值法,超时
	 public static int largestRectangleArea(int[] heights) {
		 int res = 0;
		 for (int i = 0; i < heights.length; i++) {
			if(i+1<heights.length&&heights[i]<=heights[i+1]) continue;
			int minH = heights[i];
			for (int j = i; j>=0; j--) {
				minH = Math.min(minH, heights[j]);
				int area = minH*(i-j+1);
				res = Math.max(res, area);
			}
		 }
		 return res;
	 }
	 
	 public int largestRectangleArea2(int[] height) {
	        Stack<Integer> stack = new Stack<Integer>();
	        int i = 0;
	        int maxArea = 0;
	        int[] h = new int[height.length + 1];
	        h = Arrays.copyOf(height, height.length + 1);
	        while(i < h.length){
	            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
	                stack.push(i++);
	            }else {
	                int t = stack.pop();
	                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
	            }
	        }
	        return maxArea;
	    }
	 
	 public static void main(String[] args) {
		 int[] heights = new int[] {1,3,4,5,2};
		 System.out.println(largestRectangleArea(heights));
	 }
}
