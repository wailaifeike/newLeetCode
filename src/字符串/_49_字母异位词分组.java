package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * */
public class _49_字母异位词分组 {
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		//List<List<String>> list = new LinkedList<List<String>>();
		 for (String str : strs) {
	            int[] counts = new int[26];
	            int length = str.length();
	            for (int i = 0; i < length; i++) {
	                counts[str.charAt(i) - 'a']++;
	            }
	            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
	            StringBuffer sb = new StringBuffer();
	            for (int i = 0; i < 26; i++) {
	                if (counts[i] != 0) {
	                    sb.append((char) ('a' + i));
	                    sb.append(counts[i]);
	                }
	            }
	            String key = sb.toString();
	         
	            List<String> list = map.getOrDefault(key, new ArrayList<String>());
	            System.out.println(list);
	            list.add(str);
	            map.put(key, list);
	            System.out.println(key+"-->"+list);
	        }
	        return new ArrayList<List<String>>(map.values());

    }
	
	public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }


	
	
	public static void main(String[] args) {
		String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		groupAnagrams(strings);
	}
}
