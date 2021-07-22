package 树;

import java.util.Arrays;

/*
 * 
 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
输出：[1,2,3,4,5,6,7]
 * 
 * */

public class _889_根据前序和后序遍历构造二叉树 {
	
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		
		
		return constructprepost(pre, post);
    }

	private TreeNode constructprepost(int[] pre, int[] post) {
		// TODO Auto-generated method stub
		if(pre==null||post==null||pre.length==0) return null;
		if(pre.length==1) return new TreeNode(pre[0]);
		
		TreeNode rootNode = new TreeNode(pre[0]);
		int prelen = pre.length;
		
		for (int i = 0; i < post.length; i++) {
			if(pre[1]==post[i]){
				int leftlen = i+1;
				int[] preleft = Arrays.copyOfRange(pre, 1, leftlen+1);//复制函数
				int[] postleft = Arrays.copyOfRange(post, 0,leftlen);
				
				int[] preright = Arrays.copyOfRange(pre, leftlen+1, prelen);
				int[] postright = Arrays.copyOfRange(post, leftlen, prelen-1);
				
				rootNode.left = constructprepost(preleft, postleft);
				rootNode.right = constructprepost(preright, postright);
			}
		}
		
		return rootNode;
	}
}
