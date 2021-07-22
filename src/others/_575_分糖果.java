package others;

import java.util.HashMap;
import java.util.HashSet;

/*
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。

示例 1:
输入: candies = [1,1,2,2,3,3]
输出: 3
解析: 一共有三种种类的糖果，每一种都有两个。
最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distribute-candies
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _575_分糖果 {
	public int distributeCandies(int[] candyType) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < candyType.length; i++) {
			set.add(candyType[i]);
		}
		return Math.min(set.size(), candyType.length/2);
    }
}
