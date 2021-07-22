package 树;


//最近公共祖先
class InfoTree{
	
	TreeNode fpnNode;
	boolean findo1;
	boolean findo2;
	public InfoTree(TreeNode node, boolean findo1, boolean findo2) {
		super();
		this.fpnNode = node;
		this.findo1 = findo1;
		this.findo2 = findo2;
	}
	
}

public class 二叉树的最近公共祖先 {
		
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
		return process(root,p,q).fpnNode;
    }

	public InfoTree process(TreeNode X,TreeNode o1,TreeNode o2){
		if(X==null) return new InfoTree(null, false, false);
		TreeNode node =null;
		boolean findo1;
		boolean findo2;
		
		InfoTree leftInfo = process(X.left, o1, o2);
		InfoTree rightInfo = process(X.right, o1, o2);
		
		findo1 = X==o1||leftInfo.findo1||rightInfo.findo1;
		findo2 = X==o2||leftInfo.findo2||rightInfo.findo2;
		
		if(leftInfo.fpnNode!=null) node = leftInfo.fpnNode;
		if(rightInfo.fpnNode!=null) node = rightInfo.fpnNode;
		
		if(node==null){ //leftInfo.fpnNode==null && rightInfo.fpnNode==null
			if(findo1&&findo2) node = X;
		}
		
		return new InfoTree(node, findo1, findo2);
	}
}
