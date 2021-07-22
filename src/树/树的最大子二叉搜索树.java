package 树;

class Info{
	public int subMaxSize;
	public boolean isAllbst;
	public int max;
	public int min;
	public Info(int subMaxSize,boolean isAllbst,int max,int min) {
		this.subMaxSize = subMaxSize;
		this.isAllbst = isAllbst;
		this.max = max;
		this.min = min;
	}
	
	public Info(boolean isAllbst,int max,int min) {
		this.isAllbst = isAllbst;
		this.max = max;
		this.min = min;
	}
}

public class 树的最大子二叉搜索树 {
	
	public int process(TreeNode root) {
		
		return process2(root).subMaxSize;
    }

	public Info process2(TreeNode X) {
		// TODO Auto-generated method stub
		if(X==null){
			return null;
		}
		
		int max=X.val;
		int min=X.val;
		
		Info leftInfo = process2(X.left);
		Info rightInfo = process2(X.right);
		
		if(leftInfo!=null){
			max = Math.max(max, leftInfo.max);
			min = Math.min(min, leftInfo.min);
		}
		
		if(rightInfo!=null){
			max = Math.max(max, rightInfo.max);
			min = Math.min(min, rightInfo.min);
		}
		
		int subMaxSize = 0;
		if(leftInfo!=null){
			subMaxSize = Math.max(subMaxSize, leftInfo.subMaxSize);
		}
		if(rightInfo!=null){
			subMaxSize = Math.max(subMaxSize, rightInfo.subMaxSize);
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
			
			subMaxSize = (leftInfo==null ? 0: leftInfo.subMaxSize)+1+
					(rightInfo==null ? 0: rightInfo.subMaxSize);
			
			isAllbst = true;
		}
		return new Info(subMaxSize, isAllbst, max, min);
	}
}
