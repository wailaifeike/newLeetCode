package 贪心算法;

/*
 * 
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * */

public class _309_最佳买卖股票时机含冷冻期 {
	public static int maxProfit(int[] prices) {
		if(prices.length<2) return 0;
		int N = prices.length;
		int[] buy = new int[N];
		int[] sell = new int[N];
		buy[1] = Math.max(-prices[0], -prices[1]);
		sell[1] = Math.max(0, prices[1]-prices[0]);
		for (int i = 2; i < N; i++) {
			buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
			sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
		}
		
		return sell[N-1];
    }
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,0,2,4,5,7,0};
		System.out.println(maxProfit(arr));
	}
}
