package 链表;

import java.util.ArrayList;
import java.util.List;

/*
 *给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

示例 1：
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 *  
 * */
public class _23_合并K个升序链表 {
	
	//分治法
	public  ListNode mergeKLists(ListNode[] lists) {
		if(lists==null||lists.length==0) return null;
		int n = lists.length;
	
		while (n>1) {
			int k = (n+1)/2;
			for (int i = 0; i < n/2; i++) {
				lists[i] = mergeTwoLists(lists[i],lists[i+k]);
			}
			n = k;
			
		}
		return lists[0];
    }
	
	public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode tmp = head;
		while(l1!=null&&l2!=null){
			if(l1.val<=l2.val){
				tmp.next = l1;
				l1 = l1.next;
			}else{
				tmp.next = l2;
				l2 = l2.next;
			}
			
			tmp = tmp.next;
			}
        
		if(l1==null){
			tmp.next = l2;
		}else{
			tmp.next = l1;
		}
		return head.next;
    }
	
//	public static void main(String[] args) {
//		ListNode root1 = new
//	}
}
