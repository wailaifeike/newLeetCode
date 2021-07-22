package 链表;

/*
 * 删除链表中等于给定值 val 的所有节点。
示例:
输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 * 
 * */
public class _203_移除链表元素 {
	public ListNode removeElements(ListNode head, int val) {
		if(head==null) return head;
		ListNode prev = head;
		ListNode cur = head.next;
		while (cur!=null) {
			if(cur.val==val){
				prev.next = cur.next;
				cur = cur.next;
			}else{
				cur = cur.next;
				prev = prev.next;
			}
				
		}
		if(head.val==val){
			head = head.next;
		}
		
		return head;
    }
}
