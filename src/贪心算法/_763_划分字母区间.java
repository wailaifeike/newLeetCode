package 贪心算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 *字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 *同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *示例：

输入：S = "ababcbaca defegde hijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-labels
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * */
public class _763_划分字母区间 {
	
	public static List<Integer> partitionLabels(String S) {
		List<Integer> list = new ArrayList<Integer>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < S.length(); i++) {
			map.put(S.charAt(i), i);
		}
		
		int start = 0;
		int end = 0;
//		for(Map.Entry<Character, Integer> entry:map.entrySet()) {
//			System.out.println(entry.getKey()+"-->"+entry.getValue());
//		}
		for (int i = 0; i < S.length(); i++) {
			end = Math.max(end, map.get(S.charAt(i)));
			if(i==end) {
				list.add(i-start+1);
				start = i+1;
			}
		}
		return list;
    }
	public static void main(String[] args) {
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}
}
