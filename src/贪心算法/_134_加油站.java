package 贪心算法;

import javax.naming.ldap.StartTlsRequest;

/*
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明: 

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
示例 1:

输入: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

输出: 3


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/gas-station
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _134_加油站 {
	 public static int canCompleteCircuit(int[] gas, int[] cost) {
		 int total = 0;
		 int sum =0;
		 int start = 0;
		 for (int i = 0; i < gas.length; i++) {
			total+= gas[i] - cost[i];
			sum+= gas[i] - cost[i];
			if(sum<0){
				start = i+1;
				sum=0;
			}
		 }
		 return (total<0)? -1:start;
	 }
	 
	 public static void main(String[] args) {
		int[] gas = new int[]{1,2,3,4,5};
		int[] cost = new int[]{3,4,5,1,2};
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
