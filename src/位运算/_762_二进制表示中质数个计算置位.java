package 位运算;

import java.util.HashSet;

/*
 *给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。

（注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 * */
public class _762_二进制表示中质数个计算置位 {
	
	//数据的范围限制在10^6方以内，所以是2^20次方
	public int countPrimeSetBits(int left, int right) {
		int ret = 0;
		
		HashSet<Integer> set = new HashSet<Integer>() {
			{
				add(2);
				add(3);
				add(5);
				add(7);
				add(11);
				add(13);
				add(17);
				add(19);
			}
			
		};
		for (int i = left; i <=right; i++) {
			int cnt = hammingWeight2(i);
			if(set.contains(cnt)) {
				ret++;
			}
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


}
