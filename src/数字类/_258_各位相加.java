package 数字类;

/*
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 
 * 
 * */
public class _258_各位相加 {
	public static int addDigits(int num) {
		
		 while (num / 10 > 0) {
	            int sum = 0;
	            while (num > 0) {
	                sum += num % 10;
	                num /= 10;
	            }
	            num = sum;
	        }
	        return num;
    }
	
	public static void main(String[] args) {
		System.out.println(addDigits(384));
	}
}
