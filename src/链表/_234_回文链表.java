package 链表;

/*
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
 * 输入: 1->2
	输出: false
	示例 2:
	
	输入: 1->2->2->1
	输出: true
 * 
 * */

public class _234_回文链表 {
	public boolean isPalindrome(ListNode head) {
		if(head==null) return false;
		if(head.next==null) return true;
		
		ListNode slow = head;
		ListNode fast = head;
		while (fast!=null&&fast.next!=null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		ListNode prev = null;
		while (slow!=null) {
			ListNode next = slow.next;
			slow.next = prev;
			prev = slow;
			slow = next;
		}
		
		while (prev!=null&&head!=null) {
			if(prev.val!=head.val) return false;
			prev = prev.next;
			head = head.next;
			
		}
		return true;
    }
}
