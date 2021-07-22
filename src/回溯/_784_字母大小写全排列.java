package 回溯;

import java.util.ArrayList;
import java.util.List;



/*
 给定一个字符串S，通过将字符串S中的每个字母转变大小写，
 我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
示例：
输入：S = "a1b2"
输出：["a1b2", "a1B2", "A1b2", "A1B2"]

输入：S = "3z4"
输出：["3z4", "3Z4"]

输入：S = "12345"
输出：["12345"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-case-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _784_字母大小写全排列 {
	 public static List<String> letterCasePermutation(String S) {
		 List<String> list = new ArrayList<String>();
		 
		 process(S.toCharArray(),0,list);
		 
		 return list;
	 }

	private static void process(char[] ch, int index, List<String> list) {
		if(index==ch.length) {
			String str = new String(ch);
			list.add(str);
			return;
		}
		process(ch, index+1, list);
		
		if(ch[index]>'9') {
			ch[index]^=32;
			process(ch, index+1, list);
			 
		}
	}
	
	public static void main(String[] args) {
		System.out.println(letterCasePermutation("a1b2"));
	}
}
