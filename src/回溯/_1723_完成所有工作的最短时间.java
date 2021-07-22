package 回溯;

import java.util.Arrays;

/*
给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。
工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
返回分配方案中尽可能 最小 的 最大工作时间 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * 
 * */
public class _1723_完成所有工作的最短时间 {
	class Solution {
	    int[] jobs;
	    int n, k;
	    int ans = 0x3f3f3f3f;
	    public int minimumTimeRequired(int[] _jobs, int _k) {
	        jobs = _jobs;
	        n = jobs.length;
	        k = _k;
	        int[] sum = new int[k];
	        dfs(0, 0, sum, 0);
	        return ans;
	    }
	    /**
	     * 【补充说明】不理解可以看看下面的「我猜你问」的 Q5 哦 ~
	     * 
	     * u     : 当前处理到那个 job
	     * used  : 当前分配给了多少个工人了
	     * sum   : 工人的分配情况          例如：sum[0] = x 代表 0 号工人工作量为 x
	     * max   : 当前的「最大工作时间」
	     */
	    void dfs(int u, int used, int[] sum, int max) {
	        if (max >= ans) return;
	        if (u == n) {
	            ans = max;
	            return;
	        }
	        // 优先分配给「空闲工人」
	        if (used < k) {
	            sum[used] = jobs[u];
	            dfs(u + 1, used + 1, sum, Math.max(sum[used], max));
	            sum[used] = 0;
	        }
	        for (int i = 0; i < used; i++) {
	            sum[i] += jobs[u];
	            dfs(u + 1, used, sum, Math.max(sum[i], max));
	            sum[i] -= jobs[u];
	        }
	    }
	}
}
