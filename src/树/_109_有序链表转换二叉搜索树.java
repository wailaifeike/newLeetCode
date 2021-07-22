package 树;

/*
 109. 有序链表转换二叉搜索树
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
示例:
给定的有序链表： [-10, -3, 0, 5, 9],
一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
      0
     / \
   -3   9
   /   /
 -10  5
 * 
 * 
 * */
public class _109_有序链表转换二叉搜索树 {
	 public TreeNode sortedListToBST(ListNode2 head) {
		 //
		 
		 return construct(head);
		 
		
	 }

	private TreeNode construct(ListNode2 head) {
		//将链表转为数组
		
		int[] arr = Process(head);
		if(arr==null) return null;
		return buildTreeNode(arr,0,arr.length-1);
		
	}

	private TreeNode  buildTreeNode(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if(start>end) return null;
		int mid = (start+end)>>1;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = buildTreeNode(arr, start, mid-1);
		root.right = buildTreeNode(arr, mid+1, end);
		return root;
		
	}

	private int[] Process(ListNode2 head) {
		int len = 0;
		ListNode2 tmphead = head;
		while (tmphead!=null) {
			len++;
			tmphead = tmphead.next;
			
		}
		if(len==0){
			return null;
		}
		
		int[] node_arr = new int[len];
		int index = 0;
		while (head!=null) {
			node_arr[index++] = head.val;
			head = head.next;
		}
		
		return node_arr;
		
	}
}
