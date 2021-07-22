package 树;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 
 * 
 */
public class _1302_层数最深叶子节点的和 {
	public int deepestLeavesSum(TreeNode root) {
		if(root==null) return 0;
		return calSum(root);
    }

	private int calSum(TreeNode root) {
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int sum=0;
		while (!queue.isEmpty()) {
			    sum=0;
			    int size = queue.size();	 
			    for (int i = 0; i < size; i++) {
			    	TreeNode tmpNode = queue.poll();
					sum+=tmpNode.val;
					
					if(tmpNode.left!=null) {
						queue.offer(tmpNode.left);
					} 
					if (tmpNode.right!=null) {
						queue.offer(tmpNode.right);
					}
				}
				System.out.println(sum);
				
		}
				
		return sum;
	}
	
	
	public int deepestLeavesSum2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sum = 0;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                root = queue.poll();
                sum += root.val;
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            if (queue.isEmpty()) {
                return sum;
            }
        }
        throw null;
    }
}
