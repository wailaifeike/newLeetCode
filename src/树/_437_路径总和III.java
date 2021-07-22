package 树;
/*
 给定一个二叉树，它的每个结点都存放着一个整数值。
找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
示例：
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 *  
 * */

import java.util.HashMap;
import java.util.Map;

//需要前缀和的知识解决

public class _437_路径总和III {
	public static int pathSum(TreeNode root, int targetSum) {
		if(root==null) return 0;
		if(root.left==null&&root.right==null) return root.val;
		int count = 0;
		if(root.val==targetSum)count+=1;
		
		int leftcount = pathSum(root.left, targetSum);
		int rightcount = pathSum(root.right, targetSum);
		if(leftcount==targetSum-root.val) {
			count+=1;
		}
		
		if(rightcount==targetSum-root.val) {
			count+=1;
		}
		
		return count;
    }
	
	public static int pathSum2(TreeNode root, int targetSum) {
		Map<Integer, Integer> preMap = new HashMap<Integer, Integer>();
		
		preMap.put(0, 1);
		
		return Helper(root,preMap,targetSum,0);
		//return 0;
	}
	
	private static int Helper(TreeNode root, Map<Integer, Integer> preMap, int targetSum, int curSum) {
		// TODO Auto-generated method stub
		if(root==null) return 0;
		int res = 0;
		curSum += root.val;
		res += preMap.getOrDefault(curSum-targetSum, 0);
		preMap.put(curSum, preMap.getOrDefault(curSum, 0)+1);
		
		res +=Helper(root.left, preMap, targetSum, curSum);
		res +=Helper(root.right, preMap, targetSum, curSum);
		
		preMap.put(curSum, preMap.get(curSum)-1);
		return res;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(-3);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(2);
		TreeNode node6 = new TreeNode(11);
		TreeNode node7 = new TreeNode(3);
		TreeNode node8 = new TreeNode(-2);
		TreeNode node9 = new TreeNode(1);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
	
		node3.right = node6;
		node4.left = node7;
		node4.right = node8;
		
		node5.right = node9;
		
		System.out.println(pathSum2(node1,8));
		
	}
}
