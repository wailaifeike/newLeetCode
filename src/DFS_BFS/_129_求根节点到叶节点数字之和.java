package DFS_BFS;

import java.util.ArrayList;
import java.util.List;



import 树.TreeNode;

public class _129_求根节点到叶节点数字之和 {
	public int sumNumbers(TreeNode root) {
		List<String> list = new ArrayList<String>();
		Process(root,list,"");
		
		int sum = 0;
		
		for (int i = 0; i <list.size(); i++) {
			sum+=Integer.parseInt(list.get(i));
		}
		System.out.println(list);
		return sum;
    }

	private void Process(TreeNode root,List<String> list,String res) {
		if(root==null) return ;
		res+=root.val;
		Process(root.left, list, res);		
		Process(root.right,list,res);
		if(root.left==null&&root.right==null) {
			list.add(res);
		}
		
	}
	
	public int sumNumbers2(TreeNode root) {
		
		return help(root,0);
    }

	private int help(TreeNode root, int sum) {
		// TODO Auto-generated method stub
		if(root==null) return 0;
		sum =sum*10+root.val;
		if(root.left==null&&root.right==null) {
			return sum;
		}
		return help(root.left, sum)+help(root.right, sum);
	}
}
