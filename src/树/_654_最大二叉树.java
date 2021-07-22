package 树;

;

/*
 
 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：

二叉树的根是数组 nums 中的最大元素。
左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
返回有给定数组 nums 构建的 最大二叉树 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _654_最大二叉树 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {	
		return Helper(nums,0,nums.length-1);
    }

	private TreeNode Helper(int[] nums, int start, int end) {
		// TODO Auto-generated method stub
		if(start>end) return null;
		int index = start;
		for (int i = index+1; i <=end; i++) {
			if(nums[i]>nums[index]) {
				index = i;
			}
		}
		TreeNode root = new TreeNode(nums[index]);
		
		root.left = Helper(nums, start, index-1);
		root.right = Helper(nums, index+1, end);
		
		return root;
		
	}


}
