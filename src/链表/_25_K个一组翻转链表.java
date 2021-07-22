package 链表;

/*
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
进阶：
你可以设计一个只使用常数额外空间的算法来解决此问题吗？
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */

public class _25_K个一组翻转链表 {
	 public ListNode reverseKGroup(ListNode head, int k) {
		 if(k==1) return head;
		 ListNode dummyNode = new ListNode(0);
		 ListNode pre = dummyNode;
		 ListNode cur = head;
		 dummyNode.next = head;
		
		 for (int i = 1; cur!=null; ++i) {
	            if (i % k == 0) {
	                pre = reverseK(pre, cur.next);
	                cur = pre.next;
	            } else {
	                cur = cur.next;
	            }
	     }
		 
	
		 return dummyNode.next;
	 }

	private ListNode reverseK(ListNode pre, ListNode next) {
		ListNode last = pre.next;
		ListNode cur  = last.next;
		 while(cur != next) {
	            last.next = cur.next;
	            cur.next = pre.next;
	            pre.next = cur;
	            cur = last.next;
	     }
	        return last;
	}
}
