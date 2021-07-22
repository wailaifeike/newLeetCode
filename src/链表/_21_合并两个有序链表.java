package 链表;

/*
 * https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 * 
 * z
 */

class ListNode {
	int val;
	ListNode next;
		ListNode() {}
		ListNode(int val) { 
			this.val = val; 
		}
		ListNode(int val, ListNode next) { 
			this.val = val; 
			this.next = next; 
		}
}

public class _21_合并两个有序链表 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
