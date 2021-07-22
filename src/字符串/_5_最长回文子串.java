package 字符串;

/*
 *给你一个字符串 s，找到 s 中最长的回文子串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
示例 3：
输入：s = "a"
输出："a"
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 * */
public class _5_最长回文子串 {
	public static String longestPalindrome(String s) {
	    if (s.equals(""))
	        return "";
	    String origin = s;
	    String reverse = new StringBuffer(s).reverse().toString();
	    int length = s.length();
	    int[][] arr = new int[length][length];
	    int maxLen = 0;
	    int maxEnd = 0;
	    for (int i = 0; i < length; i++)
	        for (int j = 0; j < length; j++) {
	            if (origin.charAt(i) == reverse.charAt(j)) {
	                if (i == 0 || j == 0) {
	                    arr[i][j] = 1;
	                } else {
	                    arr[i][j] = arr[i - 1][j - 1] + 1;
	                }
	            }
	            /**********修改的地方*******************/
	            if (arr[i][j] > maxLen) {
	                int beforeRev = length - 1 - j;
	                if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
	                    maxLen = arr[i][j];
	                    maxEnd = i;
	                }
	                /*************************************/
	            }
	        }
	    return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
	}
	
	
	public static void main(String[] args) {
		String string = "babad";
		System.out.println(longestPalindrome(string));
	}
}
