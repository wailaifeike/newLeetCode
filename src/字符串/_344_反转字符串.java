package 字符串;

//https://leetcode-cn.com/problems/reverse-string/
public class _344_反转字符串 {
	public static void reverseString(char[] s) {
		
		int left = 0;
		int right = s.length-1;
		while (left<=right) {
			swap(s,left,right);
			left++;
			right--;
	
		}
		System.out.println(s);
    }

	private static void swap(char[] s, int left, int right) {
		char tmp = s[left];
		s[left] = s[right];
		s[right] = tmp;		
	}
	
	public static void main(String[] args) {
		char[] s = new char[]{'h','e','l','l','o'};
		reverseString(s);
	}
}
