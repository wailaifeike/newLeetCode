package 链表;

import java.util.Stack;

/*
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorder-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 示例 1:
给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 */
public class _143_重排链表 {
	
	public void reorderList(ListNode head) {
		if(head==null||head.next==null||head.next.next==null) return;
		
		 Stack<ListNode> stack = new Stack<ListNode>();
		 ListNode cur = head;
		 while(cur!=null) {
			 stack.push(cur);
			 cur = cur.next;
		 }
		 int cnt = (stack.size()-1)/2;
		 cur = head;
		 while(cnt-->0) {
			 ListNode tmp = stack.pop();
			 ListNode next = cur.next;
			 cur.next = tmp;
			 tmp.next = next;
			 cur = next;
		 }
		 
		 stack.peek().next = null;
    }
}
