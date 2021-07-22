package 回溯;

import java.util.ArrayList;
import java.util.List;

/*
 * 输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _剑指Offer38字符串的排列 {
	
	
	 public static List<String> permutation(String s) {
		 
		 List<String> list = new ArrayList<String>();
		 char[] ch = s.toCharArray();
		 process(list, ch, 0, "");
		 return  list;
	 }
	 
	 public static void process(List<String> list,char[] ch,int index,String path){
		 if(index==ch.length){
			 list.add(path);
			 return;
			 
		 }else {
			 String pathString = path + String.valueOf(ch[index]);
			// 没有要index位置的字符
		     process(list, ch, index+1, path);
			 process(list, ch, index+1, pathString);
		}	 
		 
	 }
	 
	 public static List<String> permutation1(String s) {
			List<String> ans = new ArrayList<String>();
			if (s == null || s.length() == 0) {
				return ans;
			}
			char[] str = s.toCharArray();
			ArrayList<Character> rest = new ArrayList<Character>();
			for (char cha : str) {
				rest.add(cha);
			}
			String path = "";
			f(rest, path, ans);
			return ans;
		}

		public static void f(ArrayList<Character> rest, String path, List<String> ans) {
			if (rest.isEmpty()) {
				ans.add(path);
			} else {
				int N = rest.size();
				for (int i = 0; i < N; i++) {
					char cur = rest.get(i);
					rest.remove(i);
					f(rest, path + cur, ans);
					rest.add(i, cur);
				}
			}
		}
		
		
		

	 
	 public static void main(String[] args) {
		 List<String> resu = permutation1("AAB");
		 for (String s:resu) {
			System.out.println(s);
		}
	}
	 
	 
}
