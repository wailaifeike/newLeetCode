package 树;

/*
 * 给定一个二叉树，找出其最大深度。
	https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * */

public class _104_二叉树的最大深度 {
	 public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		int rightMax = maxDepth(root.right);
		int leftMax = maxDepth(root.left); 
		return Math.max(rightMax, leftMax)+1;
	}
}
