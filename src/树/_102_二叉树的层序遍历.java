package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 
 *给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
示例：
二叉树：[3,9,20,null,null,15,7],
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * */
public class _102_二叉树的层序遍历 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int n = queue.size();
			List<Integer> res = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				
				TreeNode t = queue.poll();
				res.add(t.val);
				if(t.left!=null) queue.add(t.left);
				if(t.right!=null) queue.add(t.right);
			}
			
			list.add(0,res);
			
			
		}
		
		return list;
    }
}
