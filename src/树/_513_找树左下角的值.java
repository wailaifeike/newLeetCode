package 树;

import java.util.LinkedList;
import java.util.Queue;

/*
 *给定一个二叉树，在树的最后一行找到最左边的值。 
*/
public class _513_找树左下角的值 {
	public int findBottomLeftValue(TreeNode root) {
		int res = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				TreeNode t = queue.poll();
				if(i==0) res = t.val;
				if(t.left!=null) queue.add(t.left);
				if(t.right!=null) queue.add(t.right);
			}
			
		}
		return res;
    }
}
