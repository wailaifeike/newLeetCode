package 字符串;

import java.awt.image.RescaleOp;
import java.util.Iterator;

/*
字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。

S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。
更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
返回任意一种符合条件的字符串T。
示例:
输入:
S = "cba"
T = "abcd"
输出: "cbad"
解释: 
S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a". 
由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/custom-sort-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _791_自定义字符串排序 {
	public static String customSortString(String S, String T) {
		int[] count = new int[26];
		StringBuffer stringBuffer = new StringBuffer();
		
		for (int i = 0; i < T.length(); i++) {
			count[T.charAt(i)-'a']++;
		}
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);					
			while (count[c-'a']-->0) {
				stringBuffer.append(c);
			}
		}
		
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);					
			while (count[c-'a']-->0) {
				stringBuffer.append(c);
			}
			
		}
		return stringBuffer.toString();
    }
	
	public static void main(String[] args) {
		String string = "cba";
		String tString = "abcd";
		System.out.println(customSortString(string,tString));
	}
}
