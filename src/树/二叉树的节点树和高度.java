package 树;


class NodeInfo{
	
	public int height;
	public int nodes;
	public NodeInfo(int h, int n) {
		this.height = h;
		this.nodes = n;
	}
	
}

public class 二叉树的节点树和高度 {
	public int countNodes(TreeNode root) {
		
		return process(root).nodes;
    }
	
	public NodeInfo process(TreeNode X){
		if(X==null){
			return new NodeInfo(0,0);
		}
		
		int height;
		int nodes;
		NodeInfo leftInfo = process(X.left);
		NodeInfo rightInfo = process(X.right);
		
		height = Math.max(leftInfo.height, rightInfo.height)+1;
		nodes = leftInfo.nodes+1+rightInfo.nodes;
		
		return new NodeInfo(height, nodes);
		
	}
}
