package 树;

/*
 * 来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
		假设一个二叉搜索树具有如下特征：
		节点的左子树只包含小于当前节点的数。
		节点的右子树只包含大于当前节点的数。
		所有左子树和右子树自身必须也是二叉搜索树。
 * */


public class _98_验证二叉搜索树 {
	 public boolean isValidBST(TreeNode root) {
        
		 return isValid(root);
	 }
	 
	 public boolean isValid(TreeNode root) {
	    if(root==null) return true;
	    boolean flag = true;
	    boolean flag2 = true;
        int cur_val = root.val;
        if(root.left!=null){
        	int left_val = root.left.val;
        	flag = left_val<cur_val? isValid(root.left):false;
        	if(!flag) return false;
        }else if(root.right!=null){
        	int right_val = root.right.val;
        	flag2 = right_val<cur_val? false:isValid(root.right);
        	if(!flag2) return false;
        }
        
        return flag&&flag2;
	}
	 
	 
	 public boolean isValidBST2(TreeNode root) {
	        
		 return process(root).isAllbst;
	 }
	 
	 
	 public Info process(TreeNode X){
		 
		if(X==null){
			return null;
		}
		
		Info leftInfo = process(X.left);
		Info rightInfo = process(X.right);
		int max = X.val;
		int min = X.val;
		
		if(leftInfo!=null){
			max = Math.max(max, leftInfo.max);
			min = Math.min(min, leftInfo.min);
		}
		
		if(rightInfo!=null){
			max = Math.max(max, rightInfo.max);
			min = Math.min(min, rightInfo.min);
		}
		
		
		boolean isAllbst = false;
		if(
				(leftInfo==null ? true :leftInfo.isAllbst)
				&&
				(rightInfo==null ? true :rightInfo.isAllbst)
				&&
				(leftInfo==null ?true: leftInfo.max<X.val)
				&&
				(rightInfo==null ?true: rightInfo.min>X.val)
				){
				
				isAllbst = true;
			}
		 
		 
		return new Info(isAllbst, max, min);
		 
	 }
	 
	 
}
