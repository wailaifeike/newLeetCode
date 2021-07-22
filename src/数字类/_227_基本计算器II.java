package 数字类;

/*
 * 
 *
给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
整数除法仅保留整数部分。
示例 1：
输入：s = "3+2*2"
输出：7 

1 <= s.length <= 3 * 105
s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
s 表示一个 有效表达式

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/basic-calculator-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

public class _227_基本计算器II {
	public static int calculate(String s) {
		
		String str = s.replace(" ", "");
		
		System.out.println();
		return 0;
    }
	
	public static int add_jian(String s){
		int sum = 0;
		
		char[] nums_char = s.toCharArray();
		sum = nums_char[0]-'0';
		for (int i = 0; i < nums_char.length; i++) {
			
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		calculate(" 3+5 / 2 ");
	}
}
