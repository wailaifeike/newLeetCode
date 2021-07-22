package 链表;

public class _147_对链表进行插入排序 {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(-1);
		ListNode cur;
		while (head!=null) {
			cur = dummy;
			ListNode tmp = head.next;
			while (cur.next!=null&&(cur.next.val<=head.val)) {
				cur = cur.next;	
			}
			
			head.next = cur.next;
			cur.next = head;
			head = tmp;
		}
		
		return dummy.next;
    }
}
