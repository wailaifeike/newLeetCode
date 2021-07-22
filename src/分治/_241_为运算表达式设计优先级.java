package 分治;

import java.util.ArrayList;
import java.util.List;
/*
 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

示例 1:
输入: "2-1-1"
输出: [0, 2]
解释: 
((2-1)-1) = 0 
(2-(1-1)) = 2
示例 2:

输入: "2*3-4*5"
输出: [-34, -14, -10, -10, 10]
解释: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _241_为运算表达式设计优先级 {
	public static List<Integer> diffWaysToCompute(String expression) {
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < expression.length(); i++) {
			if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*') {
				List<Integer> left = diffWaysToCompute(expression.substring(0, i));
				List<Integer> right = diffWaysToCompute(expression.substring(i+1, expression.length()));
				for (int k = 0; k< left.size(); k++) {
					for (int v = 0; v < right.size(); v++) {
						if(expression.charAt(i)=='+') {
							list.add(left.get(k)+right.get(v));
						}else if (expression.charAt(i)=='-') {
							
							list.add(left.get(k)-right.get(v));
						}else {
						
							list.add(left.get(k)*right.get(v));
						}
					}
				}
			}
		}
		
	    if (list.isEmpty())list.add(Integer.parseInt(expression));
		return list;
		
    }
	
	public static void main(String[] args) {
		String expression = "2*3-4*5";
		System.out.println("结果为");
		System.out.println(diffWaysToCompute(expression));
	}

	
}
