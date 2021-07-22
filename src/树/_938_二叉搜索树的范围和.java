package 树;



/*
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * 
 * */
public class _938_二叉搜索树的范围和 {
	public int rangeSumBST(TreeNode root, int low, int high) {
		return help(root,low,high);
    }

	private int help(TreeNode root, int low, int high) {
		// TODO Auto-generated method stub
		if(root==null) return 0;
		
		if(low<=root.val&&root.val<=high) {
			return root.val+help(root.left, low, high)+help(root.right, low, high);
		}else {
			return help(root.left, low, high)+help(root.right, low, high);
		}
		
		
	}
	
	public int rangeSumBST2(TreeNode root, int low, int high) {
		if(root==null) return 0;
		if(root.val<low) return rangeSumBST(root.right, low, high);
		if(root.val>high) return rangeSumBST(root.left, low, high);
		
		return root.val + rangeSumBST(root.right, low, high)+rangeSumBST(root.right, low, high);
    }
}
