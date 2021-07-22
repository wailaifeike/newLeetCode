package 字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
如果存在字母的排列 p,使得将模式中的每个字母 x 替换为 p(x) 之后,
我们就得到了所需的单词，那么单词与模式是匹配的。
（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
返回 words 中与给定模式匹配的单词列表。
你可以按任何顺序返回答案。

示例：
输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
输出：["mee","aqq"]
解释：
"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
因为 a 和 b 映射到同一个字母。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-and-replace-pattern
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _890_查找和替换模式 {
	
	  //方法一：双映射表
	  public List<String> findAndReplacePattern(String[] words, String pattern) {
		  
		 List<String> list = new ArrayList<String>(); 
		 
		 
		 for(String word:words) {
			 HashMap<Character, Character> w2pHashMap = new HashMap<Character, Character>();
			 HashMap<Character, Character> p2wHashMap = new HashMap<Character, Character>();
			 int i=0;
			 
			 for (; i < word.length(); i++) {
				 if (w2pHashMap.containsKey(word.charAt(i)) && w2pHashMap.get(word.charAt(i)) != pattern.charAt(i)) break;
				 w2pHashMap.put(word.charAt(i), pattern.charAt(i));
				 //w2p[word[i]] = pattern[i];
//            	if (p2w.count(pattern[i]) && p2w[pattern[i]] != word[i]) break;
//            	p2w[pattern[i]] = word[i];
            	 if (p2wHashMap.containsKey(pattern.charAt(i)) && p2wHashMap.get(pattern.charAt(i)) != word.charAt(i)) break;
            	 p2wHashMap.put( pattern.charAt(i),word.charAt(i));
			 }
			 if(i==word.length()) {
				 list.add(word);
			 }
		 }
				  
		  return list;
	  }
}
