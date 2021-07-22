package 树;


class TreeInfo{
	
	public boolean isBalace;
	public int height;
	TreeInfo(boolean isBalace,int height){
		this.isBalace = isBalace;
		this.height = height;
	}
	
}

public class _110_平衡二叉树 {
	public boolean isBalanced(TreeNode root) {
		
		return process2(root).isBalace;
    }
	
	
	public TreeInfo process2(TreeNode X){
		if(X==null){
			return new TreeInfo(true,0);
		}
		
		TreeInfo lefTreeInfo = process2(X.left);
		TreeInfo righTreeInfo = process2(X.right);
		int height = Math.max(lefTreeInfo.height, righTreeInfo.height)+1;
		
		boolean balaced = false;
		if(lefTreeInfo.isBalace&&righTreeInfo.isBalace&&Math.abs(lefTreeInfo.height-righTreeInfo.height)<2){
			balaced = true;
		}
		
		return new TreeInfo(balaced,height);
	}


	
}
