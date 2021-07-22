package 链表;




/*
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 
 * 输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 * 
 * */


//ListNode prev = null;
//ListNode curr = head;
//while (curr != null) {
//    ListNode nextTemp = curr.next;
//    curr.next = prev;
//    prev = curr;
//    curr = nextTemp;
//}
//return prev;



public class _206_反转链表 {
	public ListNode reverseList(ListNode head) {
		 ListNode prev = null;
		 ListNode curListNode = head;
		 ListNode nextNode;
		 while(curListNode!=null){
			 nextNode = curListNode.next;
			 curListNode.next = prev;
			 prev = curListNode;
			 curListNode = nextNode;		 
		 }
		 
		 return prev;	 
	 }
	
	
	public ListNode reverseList2(ListNode head) {
		ListNode newHead = new ListNode(-1);
		ListNode  node = head;
		 while(head!=null){
			   ListNode next = head.next;
				head.next = newHead.next; 
				newHead.next = head;
				head =next;
		 }	 
		 return newHead.next;
		 
	 }
}
