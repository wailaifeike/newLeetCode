package 树;

import java.util.LinkedList;
import java.util.Queue;

import 字符串.Test;


//两个标准
//1. 结点 有右孩子，但没有左孩子，返回false
//2. 遇到结点左右孩子不双全情况下，以后的结点必须是叶子结点



public class 判断完全二叉树 {
	//宽度优先遍历
	public static boolean isCmt(TreeNode root){
		if(root==null) return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode leftTree = null;
		TreeNode rightTree = null;
		boolean leaf = false;
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			leftTree = node.left;
			rightTree = node.right;
			
			if(
				(leaf&&(leftTree!=null||rightTree!=null))
				||
				(leftTree==null&&rightTree!=null)
				) return false;
			
			if(leftTree!=null) queue.add(leftTree);
			
			if(rightTree!=null) queue.add(rightTree);
			
			if(leftTree==null||rightTree==null) leaf = true;
			
		}
		
		
		return true;
	}
	
	
	
class FullTree{
	
	boolean isfull; // 是不是满二叉树
	boolean iscbt;  //是不是完全二叉树
	int height; // 树的高度
	public FullTree() {
		
	}
	public FullTree(boolean f, boolean c, int h) {
		this.isfull = f;
		this.iscbt = c;
		this.height = h;
		
	}
	
	public  boolean isCmt2(TreeNode root){
			
			
			
			return process3(root).iscbt;
	}
	
	public  FullTree process3(TreeNode X) {	
		if(X==null) return new FullTree(true,true,0);
		FullTree leftTree = process3(X.left);
		FullTree rightTree = process3(X.right);
		int height;
		boolean isfull;
		boolean iscbt;
		
		height = Math.max(leftTree.height, rightTree.height)+1;
		isfull = leftTree.isfull && rightTree.isfull && leftTree.height == rightTree.height;
		iscbt = false;
		if(isfull){
			iscbt = true; // 满二叉树一定是完全二叉树
		}else {
			if(leftTree.iscbt && rightTree.iscbt){
				if(leftTree.iscbt && rightTree.isfull && leftTree.height == rightTree.height+1){
					iscbt = true;
				}
				if(leftTree.isfull && rightTree.isfull && leftTree.height == rightTree.height+1){
					iscbt = true;
				}
				if(leftTree.isfull && rightTree.iscbt && leftTree.height == rightTree.height){
					iscbt = true;
				}
			}
		}
		
		return new FullTree(isfull, iscbt, height);
	}
	
}
	

public static void main(String[] args) {
		TreeNode headNode = new TreeNode(1);
		TreeNode headNode2 = new TreeNode(2);
		TreeNode headNode3 = new TreeNode(3);
		TreeNode headNode4 = new TreeNode(4);
		TreeNode headNode5 = new TreeNode(5);
		TreeNode headNode6 = new TreeNode(6);
		TreeNode headNode7 = new TreeNode(7);
		headNode.left = headNode2;
		headNode.right = headNode3;
		headNode2.left = headNode4;
		//headNode2.right = headNode5;
		//headNode3.left = headNode6;
		headNode3.right = headNode7;
		
		
		
		boolean result = isCmt(headNode);
		System.out.println(result);
		
	}
	
	
}
