package 链表;

import java.util.HashMap;
import java.util.Map;

/*
 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */

class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class _138_复制带随机指针的链表 {
	 public Node1 copyRandomList(Node1 head) {
	     if(head==null) return head;
	     Node1 root = new Node1(head.val);
	     Node1 tmpNode1 = root;
	     Node1 curNode1 = head.next;
	     Map<Node1, Node1> map = new HashMap<Node1, Node1>();
	     map.put(head, root);
	     while(curNode1!=null) {
	    	 Node1 tmp = new Node1(curNode1.val);
	    	 tmpNode1.next = tmp;
	    	 map.put(curNode1, tmp);
	    	 tmpNode1 = tmpNode1.next;
	    	 curNode1 = curNode1.next;
	     }
	     tmpNode1 = root;
	     curNode1 = head;
	     while(curNode1!=null) {
	    	 tmpNode1.random = map.get(curNode1.random);
	    	 tmpNode1 = tmpNode1.next;
	    	 curNode1 = curNode1.next;
	     }
		 return root;
	 }
}
