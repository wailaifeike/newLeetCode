package 位运算;



/*
给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，
并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。

示例 1:
输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
输出: 16 
解释: 这两个单词为 "abcw", "xtfn"。

示例 2:
输入: ["a","ab","abc","d","cd","bcd","abcd"]
输出: 4 
解释: 这两个单词为 "ab", "cd"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * */
public class _318_最大单词长度乘积 {
	 public static int maxProduct(String[] words) {
		 int res = 0;
		 int[] count = new int[words.length];
		 
		 for (int i = 0; i < words.length; i++) {
			 
			 char[] tmp = words[i].toCharArray();
			 for(char c: tmp) {
				 count[i] |= 1<<(c-'a');
			 }
			 
//			 for (int j = 0; j < count.length; j++) {
//				System.out.print(count[i]+",");
//			}
//			 System.out.println();
			 
			 for(int j = 0;j<i;j++) {
				 if((count[i]&count[j])==0) {
					 res = Math.max(res, words[i].length()*words[j].length());
				 }
			 }
		 }
		 
		 return res;
	 }
	 
	 public int maxProduct2(String[] words) {
	        int res = 0;
	        int[] wordsNum = new int[words.length];
	        for(int i = 0; i < words.length; i++) {
	            String word = words[i];
	            int num = 0;
	            for(int j = 0; j < word.length(); j++) {
	                int wei = word.charAt(j)-'a';
	                num = num | (1<<wei);
	            }
	            wordsNum[i] = num;
	        }

	        for(int i = 0; i < words.length; i++) {
	            for(int j = i+1; j < words.length; j++) {
	                if((wordsNum[i]&wordsNum[j]) != 0) continue;
	                res = Math.max(res, words[i].length()*words[j].length());
	            }
	        }

	        return res;
	    }

	 
	 public static void main(String[] args) {
		 //"a","ab","abc","d","cd","bcd","abcd"
		String[] wordsStrings  = new String[] {"abcw","baz","foo","bar","xtfn","abcdef"};
		
		System.out.println(maxProduct(wordsStrings));
	}
}
