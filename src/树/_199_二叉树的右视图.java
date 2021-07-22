package 树;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */
public class _199_二叉树的右视图 {
	//转化为二叉树的层序遍历
	public List<Integer> rightSideView(TreeNode root) {
		if(root==null) return new LinkedList<Integer>();
		List<Integer> list = new LinkedList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				TreeNode tmpNode = queue.poll();
				if(tmpNode.left!=null) queue.add(tmpNode.left);
				if(tmpNode.right!=null) queue.add(tmpNode.right);
				//每一层的最后一个元素
				if(i==size-1) list.add(tmpNode.val);
			}
			
		}
		
		return list;
    }
}
