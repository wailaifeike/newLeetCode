package 位运算;

/*
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 
 * */
public class _191_位1的个数 {
	public int hammingWeight(int n) {
		 int ret = 0;
	        while (n != 0) {
	            n &= n - 1;
	            ret++;
	        }
	        return ret;
    }
	
	public int hammingWeight2(int n) {
		    int ret = 0;
	        for (int i = 0; i < 32; i++) {
			   ret += n&1;
			   n = n>>1;
		    }
	        return ret;
   }
	
	
	public int hammingWeight3(int n) {
		
		return Integer.bitCount(n);
	}
}
