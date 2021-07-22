package others;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。

你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。
你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。

给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。
你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/brick-wall
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _554_砖墙 {
	 public static int leastBricks(List<List<Integer>> wall) {
		 int mx = 0; // 断点的长度
		 int n = wall.size();
		 Map<Integer, Integer> map =  new HashMap<Integer, Integer>();
		 
		 for(List<Integer> tmp : wall) {
			 int sum = 0;
			 int  size = tmp.size();
			 for (int i = 0; i < size-1; i++) {
				sum+=tmp.get(i);
				map.put(sum, map.getOrDefault(sum, 0)+1);
				mx = Math.max(mx, map.get(sum));
			}
		 }
		 
		 return n-mx;
	 }
	 
	 
}
