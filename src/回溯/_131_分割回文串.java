package 回溯;

import java.util.LinkedList;
import java.util.List;

/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
回文串 是正着读和反着读都一样的字符串。
示例 1：
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]


示例 2：
输入：s = "a"
输出：[["a"]]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * */
public class _131_分割回文串 {
	
	//纯回溯法
	public static List<List<String>> partition(String s) {
		List<List<String>> list = new LinkedList<List<String>>();
		List<String> ret = new LinkedList<String>();
		backtraversal(s,list,ret,0);
		return list;
    }

	private static void backtraversal(String s, List<List<String>> list,
			List<String> ret, int start_index) {
		// TODO Auto-generated method stub
		
		//递归终止条件
		if(start_index>=s.length()){
			list.add(new LinkedList<String>(ret));
		}
		for (int i = start_index; i < s.length(); i++) {
			if(isPalindrome(s,start_index,i)){
				String str = s.substring(start_index, i+1);
				ret.add(str);
				//ret.add
			}else {
				continue;
			}
			
			backtraversal(s, list, ret, i+1);
			ret.remove(ret.size()-1);
			
		}
		
	}

	private static boolean isPalindrome(String s, int start, int end) {
		// TODO Auto-generated method stub
		while (start<=end) {
			if(s.charAt(start)!=s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String string = "acca";
		System.out.println(partition(string));
	}
}
