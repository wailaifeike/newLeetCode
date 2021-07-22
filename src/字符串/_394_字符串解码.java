package 字符串;

;

/*
 * 
 给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

 

示例 1：

输入：s = "3[a]2[bc]"
输出："aaabcbc"

示例 2：
输入：s = "3[a2[c]]"
输出："accaccacc"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * */
public class _394_字符串解码 {
	String src;
    int ptr;
	public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }
    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            // String -> EPS
            return "";
        }

        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits(); 
            // 过滤左括号
            ++ptr;
            // 解析 String
            String str = getString(); 
            // 过滤右括号
            ++ptr;
            // 构造字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // String -> Char String
            // 解析 Char
            ret = String.valueOf(src.charAt(ptr++));
        }
        
        return ret + getString();
    }

    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }

    
    public static String decodeString1(String s) {
		 
		 return Process(s,0);
	 }

	private static String Process(String s, int i) {
		String reString  = "";
		int len = s.length();
		while (i<len&&s.charAt(i)!=']') {
			if(s.charAt(i)<'0'||s.charAt(i)>'9') {
				reString += String.valueOf(s.charAt(i)); //字母直接加入结果中
				i++;
			} else {
				int count = 0;
				//计算数字大小
				while (s.charAt(i)>='0'&& s.charAt(i)<='9') {
					count = count*10 + s.charAt(i)-'0';	
					i++;
				}
				++i; //越过[ 左方括号			
				String tString = Process(s,i);	
				++i;
				System.out.println(count);
				System.out.println(tString);
				while (count>0) {
					reString+=tString;	
					count--;
				}
				System.out.println("reString-->"+reString);
					
			}
				
		}
		return reString+Process(reString, i);
		
	}
	
	
	public static void main(String[] args) {
		String reString = "3[a]2[bc]";
		System.out.println();
	}
}
