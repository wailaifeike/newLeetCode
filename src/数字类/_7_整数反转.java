package 数字类;

/*
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * https://leetcode-cn.com/problems/reverse-integer/
 * 
 * 
 * */
public class _7_整数反转 {
	public int reverse(int x) {
        long sum = 0;
        while(x!=0){
            sum = sum*10+x%10;
            x/=10;
        }
        return (int)sum == sum ? (int)sum : 0;
       

    }
}
