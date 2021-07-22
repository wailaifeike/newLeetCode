package 贪心算法;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*
 * 
 * 
给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，
CPU 可以完成一个任务，或者处于待命状态。

然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的 最短时间 。


示例 1：
输入：tasks = ["A","A","A","B","B","B"], n = 2
输出：8
解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
示例 2：

输入：tasks = ["A","A","A","B","B","B"], n = 0
输出：6
解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/task-scheduler
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 * */
public class _621_任务调度器 {
	public static int leastInterval(char[] tasks, int n) {
		
		int[] count = new int[26];
		for(char c :tasks) {
			++count[c-'A'];
		}
		Arrays.sort(count);
		int i=25;
		int mx = count[25];
		//System.out.println(mx);
		int len = tasks.length;
		while (i>0&&count[i]==mx) --i;
		
		return Math.max(len, (mx-1)*(n+1)+25-i);
		
//		Map<Character, Integer> map = new HashMap<Character, Integer>();
//		for (int i = 0; i < tasks.length; i++) {
//			map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
//		}
//		int types = map.keySet().size();
//		if(types>n) return tasks.length;
		//System.out.println();
		
//		for (Entry<Character, Integer> entry:map.entrySet()) {
//			System.out.println(entry.getKey()+"--->"+entry.getValue());
//			
//		}
		//return 0;
    }
	
	
	public static void main(String[] args) {
		char[] tasks = new char[] {'A','A','A','B','B','B'};
		System.out.println(leastInterval(tasks, 2));
	}
}
