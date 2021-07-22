package DFS_BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/open-the-lock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class _752_打开转盘锁 {
	
	//本质上是迷宫遍历的问题
	public int openLock(String[] deadends, String target) {
		if("0000".equals(target)) return  0;
		Set<String> deadStrings = new HashSet<String>();
		for(String dead:deadends) {
			deadStrings.add(dead);
		}
		if(deadStrings.contains("0000")) return -1;		
		//利用队列来进行广度优先搜索
		int stp = 0;
		Queue<String> queue = new LinkedList<String>();
		Set<String> vistedSet = new HashSet<String>();
		queue.add("0000");
		vistedSet.add("0000");	
		while(!queue.isEmpty()) {
			stp++;
			int size = queue.size();
			for(int i=0;i<size;i++) {
				String curString = queue.poll();
				for(String nextString:getNextString(curString)) {
					if(!deadStrings.contains(nextString)&&!vistedSet.contains(nextString)) {
						if(nextString.equals(target)) return stp;
						queue.add(nextString);
						vistedSet.add(nextString);
						
					}
				}				
			}
			
		}
		return -1;
    }
	
	 public char getPre(char x) {
	        return x == '0' ? '9' : (char) (x - 1);
	 }

    public char getNext(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }


	
	public List<String> getNextString(String cur) {
		
		List<String> ret = new ArrayList<String>();
		char[] array = cur.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = getPre(num); // 向前转一下
            ret.add(new String(array));
            array[i] = getNext(num); // 向后转一下
            ret.add(new String(array));
            array[i] = num;  //归位
        }
        return ret;

	}
			
			
			
}
