package 树;

/*
 * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
(回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，
对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。
此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。）
题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

public class _1008_前序遍历构造二叉搜索树 {
	public TreeNode bstFromPreorder(int[] preorder) {
		
		return build(preorder, 0, preorder.length - 1);
    }
	
	 public TreeNode build(int[] preOrder, int start, int end){
	        if (start > end) return null;

	        TreeNode curRoot = new TreeNode(preOrder[start]);

	        int k = start;
	        while (k < end){
	            if (preOrder[k+1] > curRoot.val) break;
	            k++;
	        }

	        curRoot.left = build(preOrder, start+1, k);

	        curRoot.right = build(preOrder, k+1, end);

	        return curRoot;
	    }

}
