package 并差集与图;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，
 其中 edges[i] = [fromi, toi] 表示一条从点  fromi 到点 toi 的有向边。
找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
你可以以任意顺序返回这些节点编号。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-number-of-vertices-to-reach-all-nodes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class _1557_可以到达所有点的最少点数目 {
	//「最小的点集使得从这些点出发能到达图中所有点」就是入度为零的所有点的集合
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> inNode = new HashSet<Integer>();
		
		for(List<Integer> tmp:edges) {
			inNode.add(tmp.get(1));
		}
		
		for (int i = 0; i < n; i++) {
			if(!inNode.contains(i)) {
				list.add(i);
			}
		}	
		return list;
		
    }
}
