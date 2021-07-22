package 排序类;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 *给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。

实现 Solution class:

Solution(int[] nums) 使用整数数组 nums 初始化对象
int[] reset() 重设数组到它的初始状态并返回
int[] shuffle() 返回数组随机打乱后的结果
 

示例：

输入
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
输出
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shuffle-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 * 
 * */
public class _384_打乱数组 {
	
		private int[] array;
	    private int[] original;

		private Random rand = new Random();
		
		private List<Integer> getArrayCopy() {
		    List<Integer> asList = new ArrayList<Integer>();
		    for (int i = 0; i < array.length; i++) {
		        asList.add(array[i]);
		    }
		    return asList;
		}

	    public _384_打乱数组(int[] nums) {
	    	array = nums;
	    	original = nums.clone();
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	    	array = original;
	    	original = original.clone();
	    	return array;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	    	List<Integer> aux = getArrayCopy();

	        for (int i = 0; i < array.length; i++) {
	            int removeIdx = rand.nextInt(aux.size());
	            array[i] = aux.get(removeIdx);
	            aux.remove(removeIdx);
	        }

	        return array;
	    }
}
