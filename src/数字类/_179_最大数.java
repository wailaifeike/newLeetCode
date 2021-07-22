package 数字类;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/*
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

示例 1：
输入：nums = [10,2]
输出："210"


示例 2：
输入：nums = [3,30,34,5,9]
输出："9534330"


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * */
public class _179_最大数 {
	
	public static class MyComparator implements Comparator<String> {

		public int compare(String o1, String o2) {
			//return (o1 + o2).compareTo(o2 + o1);  30 3 34 5 9
			return (o2 + o1).compareTo(o1 + o2);//
		}

	}
	public static String largestNumber(int[] nums) {
		
		if(nums.length==1) return nums[0]+"";
		String ans = "";
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strs, new MyComparator());
		for (String str:strs) {
		
			ans += str;
		}
		System.out.println("--"+ans);
		char[] s = ans.toCharArray();
		   
//			int index = -1;
//			for (int i = 0; i < s.length; i++) {
//				if (s[i] == '0') {
//					index = i;
//					break;
//				}
//			}
			
			
		 return s[0] == '0' ? "0" : ans;
		
		
	 }
	 
	 public static String  getLarge(String a,String b) {
		 String tmp1 = a+b;
		 String tmp2 = b+a; 
		 int x = Integer.parseInt(tmp1);
		 int y = Integer.parseInt(tmp2);
		 return x>y ? tmp1:tmp2;
		
	 }
	 
	 public static void main(String[] args) {
		 int[] arr = new int[]{0,0};
		 System.out.println(largestNumber(arr));
	 }
	 
}
