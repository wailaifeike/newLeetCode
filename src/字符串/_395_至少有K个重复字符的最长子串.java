package 字符串;

/*
 * 
给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
示例 1：
输入：s = "aaabb", k = 3
输出：3
解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
示例 2：

输入：s = "ababbc", k = 2
输出：5
解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * */
public class _395_至少有K个重复字符的最长子串 {
	 public static int longestSubstring(String s, int k) {
		 int res = 0, i = 0, n = s.length();
	        while (i + k <= n) {
	            int mask = 0, max_idx = i;
	            int[] m = new int[26];
	            for (int j = i; j < n; ++j) {
	                int t = s.charAt(j) - 'a';
	                ++m[t];
	                if (m[t] < k){
	                	mask |= (1 << t);
	                	System.out.println(mask+"<---");
	                } 
	                else{
	                	mask &= (~(1 << t));
	                	System.out.println(mask+"++++");
	                } 
	                if (mask == 0) {
	                    res = Math.max(res, j - i + 1);
	                    max_idx = j;
	                }
	            }
	            i = max_idx + 1;
	        }
	        return res;
	 }
	 
	 public static void main(String[] args) {
		String string = "aaabb";
		int k = 3;
		System.out.println(longestSubstring(string,k));
	 }
}
