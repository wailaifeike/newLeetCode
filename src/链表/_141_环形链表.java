package 链表;

/*
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 给定一个链表，判断链表中是否有环。
 * 
 * */

public class _141_环形链表 {
	public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null) return false;
        ListNode node1 = head.next;
      
        while(node1!=null){
        	if(node1==head){
        		return true;
        	}else{
        		head = head.next;
        		if(node1.next==null) return false;
        		node1 = node1.next.next;
        	}
        }
		
		return false;
    }
}
