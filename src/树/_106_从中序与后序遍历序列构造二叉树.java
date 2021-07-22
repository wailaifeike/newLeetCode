package 树;

import java.util.HashMap;
import java.util.Map;

/*
 * 根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */

public class _106_从中序与后序遍历序列构造二叉树 {
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
		 
		 Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		 
		 for (int i = 0; i < inorder.length; i++) {
			
			 map.put(inorder[i], i);
		 }
		 return construct(map,postorder,0,inorder.length-1,0,postorder.length-1);
	 }
	 //中序遍历 inorder = [9,3,15,20,7]
	 //后序遍历 postorder = [9,15,7,20,3]
	 
	 public TreeNode construct(Map map,int[] postorder,int inorderStart,
			 int inorderEnd,int postOrderStart,int postOrderEnd ){
		
		if(inorderStart>inorderEnd|| postOrderStart> postOrderEnd) return null;
		
		int root = postorder[postOrderEnd-1]; // 获取根节点
		int root_index = (Integer) map.get(root); // 获取根节点在中序数组中的位置索引（存在map中）
		
		TreeNode node = new TreeNode(root);
		
		node.left = construct(map,postorder,inorderStart,root_index-1, postOrderStart,postOrderStart+root_index-inorderStart-1);
		node.right = construct(map, postorder, root_index+1, inorderEnd, postOrderStart + root_index - inorderStart,postOrderEnd-1);
		return node;
		 
	 }
	 
	 
	

//     int root = post[postorderEnd];//根据后序遍历结果，取得根节点
//     int rootIndexInInorderArray = inorderArrayMap.get(root);//获取对应的索引
//
//     TreeNode node = new TreeNode(root);//创建该节点
//     node.left = buildTree(inorderStart, rootIndexInInorderArray - 1, postorderStart, postorderStart + rootIndexInInorderArray - inorderStart - 1);
//     node.right = buildTree(rootIndexInInorderArray + 1, inorderEnd, postorderStart + rootIndexInInorderArray - inorderStart, postorderEnd - 1);
//     return node;//注意！返回的是新建的node！
}
