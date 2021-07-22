package 数组;

/*
 * 在二维数组grid中，grid[i][j]代表位于某处的建筑物的高度。 我们被允许增加任何数量（不同建筑物的数量可能不同）的建筑物的高度。 
 * 高度 0 也被认为是建筑物。

最后，从新数组的所有四个方向（即顶部，底部，左侧和右侧）观看的“天际线”必须与原始数组的天际线相同。 
城市的天际线是从远处观看时，由所有建筑物形成的矩形的外部轮廓。 请看下面的例子。

建筑物高度可以增加的最大总和是多少？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class _807_保持城市天际线 {
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		int res = 0;
		int[] row_max = new int[grid.length];
		int[] col_max = new int[grid[0].length];
		
		for(int i=0;i<row_max.length;i++) {
			row_max[i] = getMaxRow(grid[i]);
		}
		
		for (int i = 0; i < col_max.length; i++) {
			for (int j = 0; j < row_max.length; j++) {
				col_max[i] = Math.max(col_max[i], grid[j][i]);
			}
		}
		
//		for (int i = 0; i < col_max.length; i++) {
//			System.out.print(col_max[i]+",");
//		}
//		
//		System.out.println();
//		for (int i = 0; i < row_max.length; i++) {
//			System.out.print(row_max[i]+"_");
//		}
		
		for (int m = 0; m < grid.length; m++) {
			for (int n = 0; n < grid[0].length; n++) {
				int tmp = Math.min(row_max[m], col_max[n]);
				res+=tmp-grid[m][n];
			}
		}
		
		return res;
    }

	private static int getMaxRow(int[] is) {
		int val = 0;
		for (int i = 0; i < is.length; i++) {
			val = Math.max(val, is[i]);
		}
		return val;
	}
	
	
	public static void main(String[] args) {
		int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		int result = maxIncreaseKeepingSkyline(grid);
		
		System.out.println(result);
	}
}
