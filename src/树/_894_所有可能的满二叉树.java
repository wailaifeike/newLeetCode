package 树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
答案中每个树的每个结点都必须有 node.val=0。
你可以按任何顺序返回树的最终列表。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees

https://github.com/grandyang/leetcode/issues/894
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 * */
public class _894_所有可能的满二叉树 {
	static Map<Integer, List<TreeNode>> map = new HashMap<Integer, List<TreeNode>>();
	public static List<TreeNode> allPossibleFBT(int n) {
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(n%2==0) return list;
		if(n==1) {
			list.add(new TreeNode(0));
			return list;
		}
		
		if(map.containsKey(n)) return map.get(n);
		
		for(int i=1;i<n;i+=2) {
			List<TreeNode> left = allPossibleFBT(i);
			List<TreeNode> right = allPossibleFBT(n-i-1);
			for(TreeNode leftNode:left) {
				for(TreeNode rightNode:right) {
					TreeNode curNode = new TreeNode(0);
					curNode.left = leftNode;
					curNode.right = rightNode;
					list.add(curNode);
				}
			}
		}
		
		map.put(n, list);
		
		return map.get(n);
    }
	
	
	public static void main(String[] args) {
		List<TreeNode> tree = allPossibleFBT(7);
		System.out.println();
	}
}
