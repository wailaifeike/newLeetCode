package 链表;

/*
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
示例 1:
输入: 1->1->2
输出: 1->2
 * 
 * 
 * */


public class _83_删除链表中的重复元素 {
	
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
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null) return head;
        ListNode nextnode = head.next;
        ListNode newhead = head;

            while (nextnode!=null) {
                if(head.val!=nextnode.val){
                    head.next = nextnode;
                    head = head.next;
                }
                nextnode = nextnode.next;
            }
        head.next = nextnode;    
        return newhead;
    }
}



