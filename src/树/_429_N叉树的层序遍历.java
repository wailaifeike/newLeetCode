package 树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class _429_N叉树的层序遍历 {
	
	 public List<List<Integer>> levelOrder(Node root) {
		 if(root==null) return new ArrayList<List<Integer>>();
		 List<List<Integer>> list = new ArrayList<List<Integer>>();
		 Queue<Node> queue = new LinkedList<Node>();
		 queue.add(root);
		 while (!queue.isEmpty()) {
		 int size = queue.size();	//记录当前层数的大小

		 List<Integer> tmpList = new ArrayList<Integer>();
		 for(int i=0;i<size;i++){
			 Node cur = queue.poll();
			 tmpList.add(cur.val);
			 for(Node ch:cur.children){
				 queue.add(ch);
			 }
		 }
			
		 list.add(tmpList);
			
		 }
	     return list;
	 }
	 
	 public List<List<Integer>> levelOrder2(Node root) {
	        List<List<Integer>> ans=new ArrayList<List<Integer>>();
	        if(root==null) return ans;
	        leveltravel(ans,0,root);
	        return ans;
	    }
	    private void leveltravel(List<List<Integer>> ans, int level, Node root) {
	        if(root==null) return ;
	        if(ans.size()<level+1) ans.add(new ArrayList<Integer>());
	        ans.get(level).add(root.val);
	        int childnum=root.children.size();
	        for (int j = 0; j < childnum; j++)
	            leveltravel(ans,level+1,root.children.get(j));
	    }

	
}
