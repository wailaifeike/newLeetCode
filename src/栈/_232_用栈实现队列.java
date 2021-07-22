package 栈;

import java.util.Stack;

/*
 *请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

实现 MyQueue 类：

void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
  */
public class _232_用栈实现队列 {
	/** Initialize your data structure here. */
	Stack<Integer> inStack ;
	Stack<Integer> outStack;
    public _232_用栈实现队列() {
    	outStack = new Stack<Integer>();
         inStack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if(outStack.isEmpty()) {
    		while (!inStack.isEmpty()) {
    			outStack.push(inStack.pop());	
    		}
        	
    	}
    	
    	return outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
    	if(outStack.isEmpty()) {
    		while (!inStack.isEmpty()) {
    			outStack.push(inStack.pop());	
    		}
    	}
    	
    	return outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
    	
    	return inStack.isEmpty() && outStack.isEmpty();
    }
}
