package 并差集与图;

import java.util.ArrayList;
import java.util.List;


/*
给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）
空就是没有下一个结点了。

输入：graph = [[1,2],[3],[3],[]]
输出：[[0,1,3],[0,2,3]]
解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 * */
public class _797_所有可能的路径 {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> res = new ArrayList<Integer>();	
		Helper(graph,0,res,list);
		return list;
    }

	private void Helper(int[][] graph, int cur, List<Integer> res, List<List<Integer>> list) {
		res.add(cur);
		if(cur==graph.length-1) list.add(new ArrayList<Integer>(res));
		else {
			for(int neigh:graph[cur]) {
				Helper(graph, neigh, res, list);
			}
		}
	}
	
	public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        return solve(graph, 0);
    }

    public List<List<Integer>> solve(int[][] graph, int node) {
        int N = graph.length;
        List<List<Integer>> ans = new ArrayList();
        if (node == N - 1) {
            List<Integer> path = new ArrayList<Integer>();
            path.add(N-1);
            ans.add(path);
            return ans;
        }

        for (int nei: graph[node]) {
            for (List<Integer> path: solve(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }
}
