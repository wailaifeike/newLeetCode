package 链表;

/*
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 
 * */
public class _19_删除链表的倒数第N个节点 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode p1 = head;
		ListNode p2 = head;
		while (n>0) {
			p2 = p2.next;
			n--;
			
		}
		
		return head;
    }
}
