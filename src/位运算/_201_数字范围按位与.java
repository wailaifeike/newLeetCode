package 位运算;

/*
 * 给你两个整数 left 和 right ，表示区间 [left, right] ,返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * 
 * 
 */
public class _201_数字范围按位与 {
	public int rangeBitwiseAnd(int left, int right) {
		
		 while (left < right) right &= (right - 1);
	     return right;
    }
	
	 public  int rangeBitwiseAnd2(int m, int n) {
	        int mask = 1 << 30; // 最高位开始
	        int anw = 0;
	        while(mask > 0 && (m&mask) == (n&mask)) { //寻找相同前缀
	            anw |= m&mask;
	            mask >>= 1;
	        }
	        return anw;
	    }


}
