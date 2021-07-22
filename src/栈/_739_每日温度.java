package 栈;

import java.util.Stack;

/*
 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，
 至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/daily-temperatures
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _739_每日温度 {
	public static int[] dailyTemperatures(int[] T) {
		int[] arr = new int[T.length];
		arr[T.length-1] = 0;
		
		for (int i = arr.length-2; i >=0; i--) {
			arr[i] = findRightMax(T,i,T[i]);
		}
		return arr;
    }

	private static int findRightMax(int[] t, int i,int cur) {
		int index = i;
		while (i<t.length) {
			if(t[i]>cur) return i-index;
			i++;
			
		}
		return 0;
	}
	
	public static int[] dailyTemperatures2(int[] T) {
		int[] arr = new int[T.length];
		Stack<Integer> stack = new Stack<Integer>(); // 递减栈
		for (int i = 0; i < T.length; i++) {
			while(!stack.isEmpty()&&T[i]>T[stack.peek()]) {
				int wait_day = i-stack.peek();
				arr[stack.pop()] = wait_day;
			}
			stack.push(i); // 栈中保留的是索引下标
		}
		return arr;
    }
	
	public static void main(String[] args) {
		int[] temp = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
		
		int[] res = dailyTemperatures2(temp);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+",");
		}
	}
}
