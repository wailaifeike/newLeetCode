package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层序遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _103_二叉树的锯齿形层序遍历 {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root==null) return list;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean left_right = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> tmpList = new LinkedList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode tmpNode = queue.poll();
				int index = left_right ? i:0;
				System.out.println("index-->"+index);
				System.out.println("size"+size);
				tmpList.add(index, tmpNode.val);
				//tmpList.add(index, element);
				if(tmpNode.left!=null) queue.add(tmpNode.left);
				if(tmpNode.right!=null) queue.add(tmpNode.right);
			}
			
			list.add(tmpList);
			left_right = !left_right;	
		}
		return list;
    }
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		System.out.println(zigzagLevelOrder(node1));
		
	}
}
