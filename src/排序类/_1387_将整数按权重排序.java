package 排序类;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
如果 x 是偶数，那么 x = x / 2
如果 x 是奇数，那么 x = 3 * x + 1
比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-integers-by-the-power-value
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */
public class _1387_将整数按权重排序 {
	public static int getKth(int lo, int hi, int k) {
		List<Integer> list = new ArrayList<Integer>();
        for (int i = lo; i <= hi; ++i) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer u, Integer v) {
                if (getTo1(u) != getTo1(v)) {
                    return getTo1(u) - getTo1(v);
                } else {
                    return u - v;
                }
            }
        });
        return list.get(k - 1);
    }
	
	
	public static int getTo1(int num) {
		int count = 0;
		while (num!=1) {
			if(num%2==0) {
				num = num/2;
			}else {
				num = num *3 +1;
			}
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		getKth(7, 11, 2);
	}
}
