package 排序类;

import java.util.Arrays;

/*
 *夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，
其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，
他想要买尽可能多的雪糕。
给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
注意：Tony 可以按任意顺序购买雪糕。

示例 1：
输入：costs = [1,3,2,4,1], coins = 7
输出：4
解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 * 
 */
public class _1833_雪糕的最大数量 {
	 public static int maxIceCream(int[] costs, int coins) {
		 int res = 0;
		 Arrays.sort(costs);
		 int sum = 0;
		 for (int i = 0; i < costs.length; i++) {
			sum+=costs[i];
			if(sum>coins) break;
			res++;
		}
		 return res;
	 }
	 
	 public static void main(String[] args) {
		int[] costs = {1,6,3,1,2,5};
		int coins = 20;
		System.out.println(maxIceCream(costs, coins));
	}
}
