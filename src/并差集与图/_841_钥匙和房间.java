package 并差集与图;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _841_钥匙和房间 {
	// 图的宽度优先遍历
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int size = rooms.size();
		int visted_num = 0;
		boolean[] visted = new boolean[size];
		Queue<Integer> queue = new LinkedList<Integer>();
		visted[0] = true;
		queue.offer(0);
		while (!queue.isEmpty()) {
			int room_num = queue.poll();
			visted_num++;
			
			for(int tmp:rooms.get(room_num)) {
				if(!visted[tmp]) { // 未访问过的房间
					visted[tmp] = true;
					queue.offer(tmp);
				}
			}
			
			
			
			
		}
		return visted_num==size;
    }
}
