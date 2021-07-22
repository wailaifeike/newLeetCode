package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 
 * 给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数字的数组。

请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模后返回。

 

示例 1：

输入：nums = [1,2,3,4], n = 4, left = 1, right = 5
输出：13 
解释：所有的子数组和为 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 。将它们升序排序后，我们得到新的数组 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 1 到 ri = 5 的和为 1 + 2 + 3 + 3 + 4 = 13 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/range-sum-of-sorted-subarray-sums
 * */
public class _1508_子数组和排序后的区间和 {
	  public static int rangeSum(int[] nums, int n, int left, int right) {
		 
		  int[] pre_num = new int[(n*(n+1))/2];
		  Process2(nums, pre_num);
		  selectionSort(pre_num);
		  int sum = 0;
		  for (int i = left-1; i < right; i++) {
			sum+= pre_num[i];
		 }	 
		  
		  System.out.println(sum);
		  return sum;
	   }
	
	
	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) { 
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	private static void Process2(int[] nums,int[] pre_num) {
		// TODO Auto-generated method stub
		//List<Integer> list = new ArrayList<Integer>();
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			
			for (int j = i; j < nums.length; j++,k++) {
				sum+=nums[j];				
				pre_num[k] = sum;
			}
		}
		
		
	
		
		
	}
	
	public int rangeSum2(int[] nums, int n, int left, int right) {
        final int MODULO = 1000000007;
        int sumsLength = n * (n + 1) / 2;
        int[] sums = new int[sumsLength];
        int index = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[index++] = sum;
            }
        }
        Arrays.sort(sums);
        int ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans = (ans + sums[i]) % MODULO;
        }
        return ans;
    }


	
	public static void main(String[] args) {
		int[] arr = new int[]{5,2,1,4};
		int ans = rangeSum3(arr,4,1,10);
		System.out.println(ans);
	}
	
	
	
	  ///K路归并排序
    public static int rangeSum3(int[] nums, int n, int left, int right) {
        int  MODULO = (int) (1e9+7);
    	@SuppressWarnings({ "unchecked", "rawtypes" })
		PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
              public int compare(int[] a, int[] b){
                  return a[0] - b[0];
              }
          });
    	
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[] {nums[i], i});
        }
        
        long ans = 0;
        int count = 0;
        while (++count <= right && !pq.isEmpty()) {
            int[] cur = pq.poll();
            if (count >= left) {
            	 ans = (ans + cur[0]) % MODULO;
            }
            if (cur[1] < n - 1) {
                pq.offer(new int[]{cur[0] + nums[cur[1] + 1], cur[1] + 1});
            }
        }
        return (int) ans;
    }
}
