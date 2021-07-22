package 动态规划;

import java.util.Arrays;
import java.util.Comparator;

/*
 给定不同面额的硬币 coins 和一个总金额 amount。
 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 如果没有任何一种硬币组合能组成总金额，返回 -1。
你可以认为每种硬币的数量是无限的。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1
 * */


public class _322_零钱兑换 {
	static int res = Integer.MAX_VALUE;
	public int coinChange(int[] coins, int amount) {
		//暴力递归
		 
		 if(coins.length == 0){
	            return -1;
		 } 
		 if(res == Integer.MAX_VALUE){
	            return -1;
	      } 
		procees1(coins,amount,0);
		
	    return res;
		
    }

	private void procees1(int[] coins, int amount, int coins_num) {
		    if(amount < 0){
	            return;
	        }
	        if(amount == 0){
	            res = Math.min(res,coins_num);
	        }
	        for(int i = 0;i < coins.length;i++){
	        	procees1(coins,amount-coins[i],coins_num+1);
	        }

		
	}
	
	public static int coinChange2(int[] coins, int amount) {
		//记忆化搜索 
		 if(amount== 0){
	         return 0;
		 } 
		 int[] dp = new int[amount+1];  //其中 dp[i] 表示钱数为i时的最小硬币数的找零
		 for (int i = 0; i < dp.length; i++) {
			//初始化dp
			 dp[i] = amount+1;
		 }
		 dp[0] = 0;
		 for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if(coins[j]<=i){
					dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);  //状态转移方程 
				}
			}
		} 
		 //最大钱币数为amount
		return  (dp[amount] > amount) ? -1 : dp[amount];
    }
	
	
	public static  int coinChange3(int[] coins, int amount) {
		  if(amount== 0) return 0;
		  Arrays.sort(coins); //从大到小排序
//		  int[] copy_coins = new int[coins.length];
//		  for (int i = 0; i < copy_coins.length; i++) {
//			copy_coins[i] = coins[coins.length-1-i];
//		  }

		  helper(coins,amount,0,coins.length-1); // 从最后一个钱数大的开始
		  return (res == Integer.MAX_VALUE) ? -1 : res;
		  
    }
	
	
	private static void helper(int[] copy_coins,int leavf_money,int coins_num,int start) {
		// TODO Auto-generated method stub
		if(leavf_money==0){
			res = Math.min(res, coins_num);
			return;
		}
		if(start<0) return;
		for (int i = leavf_money / copy_coins[start]; i >= 0&&coins_num+i<res; --i) {
            helper(copy_coins, leavf_money - i * copy_coins[start], coins_num + i, start -1);
        }
		
	}
	
	
	public static void process(int[] coins, int amount, int c_index, int count){
		if (amount == 0) {
	        res = Math.min(res, count);
	        return;
	    }
	    if (c_index == coins.length) return;

	    for (int k = amount / coins[c_index]; k >= 0 && k + count < res; k--) {
	    	process(coins, amount - k * coins[c_index], c_index + 1, count + k);
	    }
		
	}
	
	public static int coinChange4(int[] coins, int amount) {
	    if (amount == 0) return 0;
	    //sort(coins.rbegin(), coins.rend());
	    //int ans = INT_MAX;
	    Arrays.sort(coins);
	    
		int[] copy_coins = new int[coins.length];
		for (int i = 0; i < copy_coins.length; i++) {
			copy_coins[i] = coins[coins.length-1-i];
		}
	    process(copy_coins, amount, 0, 0);
	    return res == Integer.MAX_VALUE ? -1 : res;
	}


	
	public static void main(String[] args) {
		
		int[] arr = new int[]{411,412,413,414,415,416,417,418,419,420,421,422};
		System.out.println(coinChange3(arr,9864));
	}

	  

}
