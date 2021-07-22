package 位运算;

/*
 * 解题思路
因为该数num在0-1.0之间，因此可以采用折半比较法，与s（初始值0.5（二进制是0.1））进行比较:
1.如果num比较小，则直接在小数点后面添加0,然后再让它与0.25（s/2,二进制是0.01）进行比较;
2.如果num比较大，则小数点后的第一位则是1，更新num为num-s,此时num必定介于0-0.5之间，然后更新s为0.25。


*二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，
 打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
示例1:
 输入：0.625
 输出："0.101"
示例2:

 输入：0.1
 输出："ERROR"
 提示：0.1无法被二进制准确表示

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bianry-number-to-string-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _面试题05_02_二进制数转字符串 {
	public static String printBin(double num) {
        if(num>1||num<0) return "ERROR";
        StringBuffer sb=new StringBuffer();
        double s=0.50;
        sb.append("0.");//该数是0-1之间的小数，因此先添加0.
        while(num>0){
            if(sb.length()>32) return "ERROR";//超出32位的计算精度
            if(num<s) sb.append("0");
            else{
                num=num-s;
                sb.append("1");
            }
            s/=2;
        }
        return sb.toString();
    }
	
	
	public static void main(String[] args) {
		String resultString = printBin(0.625);
		System.out.println(resultString);
	}
}
