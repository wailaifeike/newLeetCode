package 动态规划;

import java.util.HashSet;
import java.util.List;


/*
 * 
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。

示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-break

参考代码
https://leetcode-cn.com/problems/word-break/solution/dong-tai-gui-hua-jian-zhi-yu-you-hua-si-t4s6n/
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * */
public class _139_单词拆分 {
	 public  boolean wordBreak(String s, List<String> wordDict) {
		 int Maxlen = 0;
		 HashSet<String> set = new HashSet<String>();
		 for (String string:wordDict) {
			Maxlen = Math.max(Maxlen, string.length());
			set.add(string);
					
		 }
		 
		   //增加一位，dp[0]表示j为空字符串。避免开头的-1坐标讨论
		    boolean[] dp = new boolean[s.length() + 1];
		    //空集也是dictSet的子集
		    dp[0] = true;
		    int last = -1; 
	        for(int i = 0; i < s.length(); i++){
	            //已有超过最大单词长度的字符未匹配
	            if(i - last > Maxlen){
	                return false;
	            }
	            //j多一位，j = i时，表示只有s.charAt(i)一个字符
	            //未匹配的字符最多只能有maxLen的长度, 所以j的起点为i + 1 - manLen（不小于0）
	            for(int j = Math.max(i + 1 - Maxlen, 0); j < i + 1; j++){
	                if(dp[j] && set.contains(s.substring(j, i+1))){
	                    //找到一个满足条件的拆分即可
	                    dp[i + 1] = true;
	                    last = i;
	                    break;
	                }
	            }
	        }
	        return dp[s.length()];
	 }
 
}
