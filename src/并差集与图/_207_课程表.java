package 并差集与图;

import java.util.ArrayList;
import java.util.List;




/*
 * 
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

 

示例 1：

输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 
 * 
 * */

//有向图中检测是否有环
public class _207_课程表 {
	
	List<List<Integer>> edges;
	int[] visted;
	boolean valid = true;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<List<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			edges.add(new ArrayList<Integer>()); // 为每一个节点建立边
		}	
		visted = new int[numCourses];
		for (int[] info:prerequisites) {
			edges.get(info[1]).add(info[0]); // info[1] 先修课-----》   info[0] 
		}		
		for (int i = 0; i < numCourses&&valid; i++) {
			if(visted[i]==0){ // 未被访问过
				dfs(i);
			}
		}
		return valid;
    }
	
	public void dfs(int x) {
		visted[x] = 1;
		for (int v:edges.get(x)) {
			if(visted[v]==0){
				dfs(v);
				if(!valid) return;
			}else if(visted[v]==1){
				valid = false;
				return;
			}
		}
		visted[x] = 2;// 进栈	
	}
}
