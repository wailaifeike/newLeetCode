package DFS_BFS;

/*
有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
你允许：
装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
示例 1: (From the famous "Die Hard" example)

输入: x = 3, y = 5, z = 4
输出: True

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/water-and-jug-problem
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */
public class _365_水壶问题 {
	 public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
		 	
		 return targetCapacity == 0 || (jug1Capacity + jug2Capacity >= targetCapacity 
				 && targetCapacity % gcd(jug1Capacity,jug2Capacity) == 0);
	
	 }

	private int gcd(int x, int y) {
		// TODO Auto-generated method stub
		 return y == 0 ? x : gcd(y, x % y);
	}
}
