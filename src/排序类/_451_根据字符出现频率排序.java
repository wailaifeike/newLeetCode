package 排序类;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
示例 1:
输入:
"tree"
输出:
"eert"
解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。

示例 2:
输入:
"cccaaa"
输出:
"cccaaa"
解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _451_根据字符出现频率排序 {
	 public static String frequencySort(String s) {
		 
		 Map<Character, Integer> map = new HashMap<Character, Integer>();
		 
		 for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		 }
		 
		 List<Character>[] list = new List[s.length()+1];
		 
		 for(Map.Entry<Character, Integer> entiy:map.entrySet()) {
//			 System.out.println(entiy.getValue()+"-->"+entiy.getKey());
//			 for(int i=1;i<=entiy.getValue();i++) {
//				  list.add(0, entiy.getKey());
//			 }
			 int num = entiy.getValue();
			 if(list[num]==null) {
				 list[num] = new ArrayList<Character>();
			 }
			 
			 list[num].add(entiy.getKey()); // 然后将字符放到桶中
			
		 }
		 		 
		 StringBuffer stringBuffer = new StringBuffer();
		 
		 for (int i = list.length - 1; i > 0; --i) {
	            // 遍历每个桶
	            if (list[i] != null) {
	                // 如果桶里有字符
	                for (char j : list[i]) {
	                    // 遍历桶里的每个字符
	                    for (int k = i; k > 0; --k) {
	                        // 字符出现了几次就向 res 中添加几次该字符
	                    	stringBuffer.append(j);
	                    }
	                }
	            }
	        }

	        return stringBuffer.toString();
	 }
	 
	 public static void main(String[] args) {
		String string = "abbbcc";
		System.out.println(frequencySort(string));
	}
}
