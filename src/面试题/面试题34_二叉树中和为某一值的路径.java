package 面试题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import 树.TreeNode;

/*
 * 
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。



示例:
给定如下二叉树，以及目标和 target = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof

 * 
 * */
public class 面试题34_二叉树中和为某一值的路径 {
	 static List<List<Integer>> list = new LinkedList<List<Integer>>();
	 public List<List<Integer>> pathSum(TreeNode root, int target) {
		 List<List<Integer>> result = new LinkedList<List<Integer>>();
		 pathSum2(root,new LinkedList<Integer>(),result,target);
		 
		 	return result;
	 }
	 
	 public static void pathSum2(TreeNode root,List<Integer> path,List<List<Integer>> tmpList,int target) {
		 	
		 	if (root != null) {
		 		List<Integer> path2 = new LinkedList<Integer>(path);
		 		path2.add(root.val);
	            if (root.left == null && root.right == null) {  // 当前节点是叶子节点	
	            	int sum=0;
	            	for(int i=0 ;i< path2.size();i++){
	            		sum += path2.get(i);
	            	}
	            	if(sum ==target) tmpList.add(path2);  // 把路径加入到答案中
	            } else {
	            	pathSum2(root.left,path2, tmpList,target);
	            	pathSum2(root.right, path2,tmpList,target);
	            }
	        }

		
	 }
	 
	 
	 public static void pathSum3(TreeNode root,List<Integer> path,List<List<Integer>> tmpList,int target) {
		  if (root == null)
		     return;	 
	 		 path.add(root.val);
	 		 if (root.left == null && root.right == null) {  // 当前节点是叶子节点	
	 			 if(target==root.val) 
	 				 tmpList.add(new ArrayList<Integer>(path)); // 最重要的错误
	 			 	 //tmpList.add(path);
	 			 path.remove(path.size()-1);
	 			 return;
	         }
	 		 
	 		 pathSum3(root.left, path, tmpList, target-root.val);
	 		 pathSum3(root.right, path, tmpList, target-root.val);
	 		
	 		 path.remove(path.size() - 1);
		
	 }
	 
	 public static void dfs(TreeNode root, int sum, int toal, List<Integer> list,
             List<List<Integer>> result) {
			 //如果节点为空直接返回
				 if (root == null)
				     return;
				 //把当前节点值加入到list中
				 list.add(new Integer(root.val));
				 //没往下走一步就要计算走过的路径和
				 toal += root.val;
				 //如果到达叶子节点，就不能往下走了，直接return
				 if (root.left == null && root.right == null) {
				     //如果到达叶子节点，并且sum等于toal，说明我们找到了一组，
				     //要把它放到result中
				     if (sum == toal)
				         result.add(new ArrayList(list));
				     //注意别忘了把最后加入的结点值给移除掉，因为下一步直接return了，
				     //不会再走最后一行的remove了，所以这里在rerurn之前提前把最后
				     //一个结点的值给remove掉。
				     list.remove(list.size() - 1);
				     //到叶子节点之后直接返回，因为在往下就走不动了
				     return;
				 }
				 //如果没到达叶子节点，就继续从他的左右两个子节点往下找
				 dfs(root.left, sum, toal, list, result);
				 dfs(root.right, sum, toal, list, result);
				 //我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
				 //我们把这个值使用完之后还要把它给移除，这就是回溯
				 list.remove(list.size() - 1);
				}
	
	
public static void dfs2(TreeNode root, int sum, List<Integer> list,
	             List<List<Integer>> result) {
		 //如果节点为空直接返回
		 if (root == null)
		     return;
		 //把当前节点值加入到list中
		 list.add(new Integer(root.val));
		 //如果到达叶子节点，就不能往下走了，直接return
		 if (root.left == null && root.right == null) {
		     //如果到达叶子节点，并且sum等于叶子节点的值，说明我们找到了一组，
		     //要把它放到result中
		     if (sum == root.val)
		         result.add(new ArrayList(list));
		     //注意别忘了把最后加入的结点值给移除掉，因为下一步直接return了，
		     //不会再走最后一行的remove了，所以这里在rerurn之前提前把最后
		     //一个结点的值给remove掉。
		     list.remove(list.size() - 1);
		     //到叶子节点之后直接返回，因为在往下就走不动了
		     return;
		 }
		 //如果没到达叶子节点，就继续从他的左右两个子节点往下找，注意到
		 //下一步的时候，sum值要减去当前节点的值
		 dfs2(root.left, sum - root.val, list, result);
		 dfs2(root.right, sum - root.val, list, result);
		 //我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
		 //我们把这个值使用完之后还要把它给移除，这就是回溯
		 list.remove(list.size() - 1);
}

	 
	 
	 
	 public static TreeNode getRoot(){
		 TreeNode num1 = new TreeNode(5);
		 TreeNode num2 = new TreeNode(4);
		 TreeNode num3 = new TreeNode(8);
		 TreeNode num4 = new TreeNode(11);
		 TreeNode num5 = new TreeNode(13);
		 TreeNode num6 = new TreeNode(4);
		 TreeNode num7 = new TreeNode(7);
		 TreeNode num8 = new TreeNode(2);
		 TreeNode num9 = new TreeNode(5);
		 TreeNode num10 = new TreeNode(1);
		 num1.left = num2;
		 num1.right = num3;
		 num2.left = num4;
		 //num2.right = num4;
		 num4.left = num7;
		 num4.right = num8;
		 num3.left = num5;
		 num3.right = num6;
		 num6.left = num9;
		 num6.right = num10;
		 return num1;
	 }
	 public static void main(String[] args) {
		 TreeNode rootNode =  getRoot();
		 //System.out.println(rootNode);
		 List<List<Integer>> result1 = new LinkedList<List<Integer>>();
		 pathSum3(rootNode,new LinkedList<Integer>(),result1,22);
		 //dfs(rootNode, 22, 0, new LinkedList<Integer>(), result1);
	     //dfs2(rootNode, 22, new LinkedList<Integer>(), result1);
		 System.out.println(result1);
//		 for(List<Integer> a:result){
//			 System.out.println(a);
//		 }
	}
}
