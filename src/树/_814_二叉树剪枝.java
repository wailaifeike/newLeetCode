package 树;

/*
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。

返回移除了所有不包含 1 的子树的原二叉树。

(节点X的子树为X本身，以及所有X的后代。)

示例1:
输入: [1,null,0,0,1]
输出: [1,null,0,null,1]
解释: 
只有红色节点满足条件“所有不包含 1 的子树”。
右图为返回的答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-pruning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _814_二叉树剪枝 {
	
	//我们可以不断的移除值为0的叶结点，全都移除后那么值全为0的子树也就都被移除了。
	public TreeNode pruneTree(TreeNode root) {
        
		return proces(root);
    }

	private TreeNode proces(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) return null;

		root.left = proces(root.left);
		root.right = proces(root.right);
		
		// 后序遍历
		if(root.val==0&&root.left==null&&root.right==null) {
			
			return null;
		}		
		return root;
	}
}
