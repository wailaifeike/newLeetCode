package 树;

import java.util.ArrayList;
import java.util.List;

public class _1305_两棵二叉搜索树中的所有元素 {
	 public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		 List<Integer> list1 = new ArrayList<Integer>();
		 List<Integer> list2 = new ArrayList<Integer>();
		 List<Integer> res = new ArrayList<Integer>();
		 
		 dfs(root1,list1);
		 dfs(root2,list2);
		 System.out.println(list1);
		 System.out.println(list2);
		 int i = 0, j=0;
		 
		while (i<list1.size()&&j<list2.size()) {
			 int value = list1.get(i)<=list2.get(j)?list1.get(i++):list2.get(j++);
			 res.add(value);
			
		}
		
		while (i<list1.size()) {
			 res.add(list1.get(i++));			
		}
		while (j<list2.size()) {
			 res.add(list2.get(j++));			
		}
		 return res;
	 }

	private void dfs(TreeNode root, List<Integer> list) {
		if(root==null) return;
		
		dfs(root.left, list);
		list.add(root.val);
		dfs(root.right, list);
		
	}
}
