package 树;

public class _1315_祖父节点值为偶数的节点和 {
	 int sum = 0;
	 int xx = 0;
	 public int sumEvenGrandparent(TreeNode root) {
		 
		 return dfs(root);
	 }

	private int dfs(TreeNode root) {
		
		if(root==null) return sum;
		if(root.val%2==0&&hasGraSon(root)) {
			sum+=sumGraSon(root);
		}
		dfs(root.left);
		dfs(root.right);
		return sum;
	}

	private int sumGraSon(TreeNode root) {
		
		 if(root == null) return 0;
	     else return sumSon(root.left) + sumSon(root.right);
	}

	private int sumSon(TreeNode root) {
		if(root == null) return 0;
		return (root.left==null? 0:root.left.val)+(root.right==null? 0:root.right.val);
	}

	private boolean hasGraSon(TreeNode root) {
		if(root==null) return false;
		if(!(hasSon(root.left) || hasSon(root.right))) return false;
        return true;
		
	}

	private boolean hasSon(TreeNode root) {
		if(root==null) return false;
		if(root.left==null&&root.right==null) return false;
		return true;
	}
}
