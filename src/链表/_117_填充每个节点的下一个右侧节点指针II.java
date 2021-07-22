package 链表;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * 
 * 
 * 
 */
public class _117_填充每个节点的下一个右侧节点指针II {
	public Node connect(Node root) {
		 if(root==null) return root;
		 Queue<Node> queue = new LinkedList<Node>();
		 queue.add(root);
		 while(!queue.isEmpty()) {
			 int size = queue.size();
			 Node lastNode = null;
			 
			 for(int i=1;i<=size;i++) {
				 Node curNode = queue.poll();
				 if(curNode.left!=null) {
					 queue.add(curNode.left);
				 }
				 if(curNode.right!=null) {
					 queue.add(curNode.right);
				 }
				 if(i!=1) {
					 lastNode.next = curNode;
				 }
				 lastNode = curNode;
			 }
		 }
		 return root;
    }
}
