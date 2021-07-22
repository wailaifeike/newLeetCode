package 树;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * 
 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _297_二叉树的序列化与反序列化 {
	  // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root==null) return "";
    	String string = "";	
    	return preSerialize(root,string);
    }
    
    
    public static String preSerialize(TreeNode root,String str){
    	if(root==null) str+="none#";
    	else {
			str+=root.val+"#";
			preSerialize(root.left, str);
			preSerialize(root.right, str);
		}
    	
    	return str;
    	
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return new TreeNode();
        String[] data_array = data.split("#");
        Queue<String> queue  = new LinkedList<String>();
        for (int i = 0; i < data_array.length; i++) {
			queue.add(data_array[i]);
		}
        
    	return buildNode(queue);
    }
    
    public static TreeNode buildNode(Queue<String> queue ){
    	
    	
    		if(!queue.isEmpty()){
    			if(queue.peek().equals("none")){
    	       		 queue.poll();
    	              return null;
    	    	}else{
    	    			  TreeNode root = new TreeNode(Integer.valueOf(queue.poll()));
    	    	           root.left = buildNode(queue);
    	    	           root.right = buildNode(queue);
    	    	           return root;
    	    		 }
    		}else{
    			
    			return new TreeNode();
    		}
    		
    		
       	   
    	  }
    	  
    
}
