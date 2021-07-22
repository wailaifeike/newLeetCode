package 链表;

/*
 * 
给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * */
public class _1669_合并两个链表 {
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
		ListNode prea = list1;
		ListNode aftb = list1;
		ListNode tmp = list2;
		
		while (a>1) {
			prea = prea.next;
			a--;			
		}
		while (b>0) {
			aftb = aftb.next;
			b--;
		}
		
		while (tmp.next!=null) {
			tmp = tmp.next;
			
		}
		
		tmp.next = aftb.next;
		aftb.next = null;
		prea.next = list2;	
		return list1;
    }
}
