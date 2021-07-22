package 数组;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

//堆排序和快速排序
public class _215_数组中的第K个最大元素 {
	
	//堆排序
	public static int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        
//        for (int i = 0; i < nums.length; i++) {
//			System.out.print(nums[i]+",");
//		}
        
        //return 0;
        
        //调整大顶堆的过程
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public static void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        } 
    }
    
    
    //建立大顶堆得过程
    public static void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        } 
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
    	int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
    	System.out.println(findKthLargest2(arr,4));
	}
    
    
    //左半部分的所有值都大于右半部分的任意值，所以我们求出中枢点的位置，如果正好是 k-1，
    //那么直接返回该位置上的数字；如果大于 k-1，说明要求的数字在左半部分，
     //更新右边界，再求新的中枢点位置；反之则更新右半部分，求中枢点的位置；不得不说，这个思路真的是巧妙啊～
    public static int findKthLargest2(int[] nums, int k) {
        
        return quickSelect(nums,0,nums.length-1,k);
    }

	private static int quickSelect(int[] nums, int L, int R, int k) {
		while (true) {
			int pos = partation(nums,L,R);
			if(pos==k-1) return nums[k-1];
			if(pos>k-1) R = pos-1;
			else {
				L = pos+1;
			}
		}
	
	}

	private static int partation(int[] nums, int left, int right) {
		int mid_value = nums[left];
		int l = left+1;
		int r = right;
		while (l<=r) {
			if(nums[l]<mid_value&&nums[r]>mid_value){
				swap(nums, l++, r--);
			}
			if(nums[l]>=mid_value) l++; 
			if(nums[r]<=mid_value) r--;
		}
		
		swap(nums,left, r);
        return r;		
	}
	

}
