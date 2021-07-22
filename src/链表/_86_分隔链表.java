package 链表;

/*
 * 给你一个链表的头节点 head 和一个特定值 x ，
 * 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

你应当 保留 两个分区中每个节点的初始相对位置。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */
public class _86_分隔链表 {
	 public ListNode partition(ListNode head, int x) {
		 ListNode smallListNode = new ListNode(0);
		 ListNode largeListNode = new ListNode(0);
		 ListNode smallHead = smallListNode;
		 ListNode largeHead = largeListNode;
		 while (head!=null) {
			if(head.val<x) {
				smallHead.next = head;
				smallHead = smallHead.next;
			}else {
				largeHead.next = head;
				largeHead = largeHead.next;
			}
			head = head.next;
		}
		 
		 largeHead.next = null;
		 
		 smallHead.next = largeListNode.next;
		 
		 return smallListNode.next;
	 }
}
