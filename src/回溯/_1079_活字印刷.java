package 回溯;

import java.util.Arrays;

/*
 * 
 
你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
注意：本题中，每个活字字模只能使用一次。

 示例 1：
输入："AAB"
输出：8
解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-tile-possibilities
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */
public class _1079_活字印刷 {
	public int numTilePossibilities(String tiles) {
		   char[] chars = tiles.toCharArray();
		    //先排序，目的是让相同的字符挨着，在下面计算的时候好过滤掉重复的
		    Arrays.sort(chars);
		    int[] res = new int[1];
		    backtrack(res, chars, new boolean[tiles.length()], tiles.length(), 0);
		    return res[0];

    }
	
	private void backtrack(int[] res, char[] chars, boolean[] used, int length, int index) {
	    //如果没有可以选择的就返回
	    if (index == length)
	        return;
	    //注意，这里的i每次都是从0开始的，不是从index开始
	    for (int i = 0; i < length; i++) {
	        //一个字符只能选择一次，如果当前字符已经选择了，就不能再选了。
	        if (used[i])
	            continue;
	        //过滤掉重复的结果
	        if (i - 1 >= 0 && chars[i] == chars[i - 1] && !used[i - 1])
	            continue;
	        //选择当前字符，并把它标记为已选择
	        used[i] = true;
	        res[0]++;//选择一个字符，就多了一种结果
	        //下一分支继续递归
	        backtrack(res, chars, used, length, index + 1);
	        //使用完之后再把它给复原。
	        used[i] = false;
	    }
	}

}
