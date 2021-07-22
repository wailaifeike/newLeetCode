package 树;



/*
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

提醒一下，二叉搜索树满足下列约束条件：

节点的左子树仅包含键 小于 节点键的节点。
节点的右子树仅包含键 大于 节点键的节点。
左右子树也必须是二叉搜索树。
注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _538_把二叉搜索树转换为累加树 {
	
	 static int sum = 0;
	 public static TreeNode convertBST(TreeNode root) {
		 
		 return Helper(root);
	 }

	private static TreeNode Helper(TreeNode root) {
		if(root==null) return null;
		Helper(root.right);
		
		root.val+=sum;
		sum = root.val;
		Helper(root.left);
	
		return root;
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
	}
}
