package 位运算;

/*
有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
并返回一个包含给定查询 queries 所有结果的数组。

示例 1：
输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
输出：[2,7,14,8] 
解释：
数组中元素的二进制表示形式是：
1 = 0001 
3 = 0011 
4 = 0100 
8 = 1000 
查询的 XOR 值为：
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * Q(left,right)
=arr[left]⊕…⊕arr[right]
=(arr[0]⊕…⊕arr[left−1])⊕(arr[0]⊕…⊕arr[left−1])⊕(arr[left]⊕…⊕arr[right])
=(arr[0]⊕…⊕arr[left−1])⊕(arr[0]⊕…⊕arr[right])
=xors[left]⊕xors[right+1]
​	
 



作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/xor-queries-of-a-subarray/solution/zi-shu-zu-yi-huo-cha-xun-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 * */
public class _1310_子数组异或查询 {
	public int[] xorQueries(int[] arr, int[][] queries) {
		
		int n = arr.length;
        int[] xors = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return ans;


	
    }
}
