package 数字类;

import java.util.Currency;
import java.util.Stack;

/*
 * 示例 2：
 * 
https://leetcode-cn.com/problems/basic-calculator/
224. 基本计算器
给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
输入：s = " 2-1 + 2 "
输出：3
示例 3：

输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23
 * 
 * */
public class _224_基本计算器 {
	public static int calculate(String s) {
		int res = call1(s);
		return res;
    }

	private static int call1(String s) {
		int res = 0;
		int sign = 1;
		Stack<Integer> stack = new Stack<Integer>();	
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c==' ') continue;
			if('0'<=c&&c<='9'){
				int tmp = c -'0';
				while (i<s.length()-1&&('0'<=s.charAt(i+1)&&s.charAt(i+1)<='9')) {
					tmp = tmp*10 +s.charAt(i+1)-'0';
					i++;
				}
				res += tmp*sign;
			}
			else if(c=='+') sign=1;
			else if(c=='-') sign=-1;
			else if(c=='('){
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign=1;
			}
			else if(c==')'){
				int sigal = stack.pop();
				res = res * sigal;
				int num = stack.pop();
				res = res + num;
			}
		}
		return res;
	}
	
	
	
	public static int call2(String s){
		int res = 0;
		int sign = 1;
		char m_d = '$';
		Stack<Integer> stack = new Stack<Integer>();	
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c==' ') continue;			
			if('0'<=c&&c<='9'){
				int tmp = c -'0';
				while (i<s.length()-1&&('0'<=s.charAt(i+1)&&s.charAt(i+1)<='9')) {
					tmp = tmp*10 +s.charAt(i+1)-'0';
					i++;
				}
								
				if(m_d!='$'){
					if(m_d=='*') tmp = stack.pop() *tmp;
					if(m_d=='/') tmp = stack.pop() /tmp;
					m_d = '$';
				}				
				stack.push(tmp);				
			}			
			else if(c=='*'||c=='/'){
				m_d = c;
			}			
			else if(c=='+'||c=='-'){
				res = res +stack.pop() *sign;
				sign= c=='+' ? 1:-1;
			}
			
		}
		return res + stack.pop() *sign; //最后一次计算
	}
	
	public static void main(String[] args) {
		int result = calculate(" 2-1 + 2 ");
		int s  = call2("2*6+3-2 ");
		System.out.println(result);
		System.out.println(s);
	}
}
