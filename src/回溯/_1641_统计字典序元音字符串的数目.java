package 回溯;

/*
 * 
 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 * */
public class _1641_统计字典序元音字符串的数目 {

	public int countVowelStrings(int n) {
		int a = 1, b = 1, c = 1, d = 1, e = 1;
	    for (int i = 0; i < n - 1; i++) {
	      b += a;
	      c += b;
	      d += c;
	      e += d;
	    }
	    return a + b + c + d + e;
    }

	
}
