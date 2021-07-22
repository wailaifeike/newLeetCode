package 数字类;




class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class _2_两数相加 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode list1 = null;
		
		ListNode p1 = l1;
		ListNode p2=l2;
		int n1=0;
		int n2 = 0;
		int ca = 0;
		
		return list1;
    }
	
	
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
}
