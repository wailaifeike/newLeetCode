package 字符串;

/*
 * 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 
 * class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * */
public class _14_最长公共前缀 {
	 public String longestCommonPrefix(String[] strs) {
		  if(strs==null) return null;
		  String maxpre = strs[0];
		  for (int i = 0; i < strs.length-1; i++) {
			maxpre = getString(maxpre,strs[i+1]);
		  }
		  return maxpre;
	 }
	 
	 public String getString(String str1,String str2){
		 String compreString = "";
		 int minlen = str1.length()>str2.length()?str2.length():str1.length();
		 for (int i = 0; i < minlen; i++) {
			 if(str1.charAt(i)!=str2.charAt(i)){
				 return compreString;
			 }
			 
			if(str1.charAt(i)==str2.charAt(i)){
				compreString+=str1.charAt(i);
			}
		 }
		
		 return compreString;
	 }
}
