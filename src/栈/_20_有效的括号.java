package 栈;

import java.util.Stack;

public class _20_有效的括号 {
	static Stack<Character> instackStack = new Stack<Character>();

	 public static boolean isValid(String s) {
		 for (int i = 0; i < s.length(); i++) {
			 
			 char c = s.charAt(i);
			 if(c=='('||c=='['||c=='{'||c=='<'){
				 instackStack.push(c);
			 }else{				
				 if(instackStack.isEmpty()) return false;
				 char left = instackStack.pop();
				 if(left=='('&&c!=')') return false;
				 if(left=='['&&c!=']') return false;
				 if(left=='{'&&c!='}') return false;
				 if(left=='<'&&c!='>') return false;
				 
			 }
			
		}
		 return instackStack.empty();

	 }
	 
	 public static void main(String[] args) {
		String string = "[<>{}(())]";

		System.out.println(isValid(string));
	 }

}
