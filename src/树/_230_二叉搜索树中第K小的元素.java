package 树;

/*
 * 
 https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/

 230. 二叉搜索树中第K小的元素
 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 
 * 
 * */
public class _230_二叉搜索树中第K小的元素 {
	//二分查找
	public int kthSmallest(TreeNode root, int k) {
		int left_num = count_num(root.left);
		if(left_num==k-1) return root.val;
		else if(left_num>=k){
			return kthSmallest(root.left,k);
		}else {
			return kthSmallest(root.right, k-left_num-1);
		}
			
	}
	
	public int count_num(TreeNode root){
		if(root==null) return 0;
		
		return count_num(root.left)+count_num(root.right)+1;
		
	}
}
