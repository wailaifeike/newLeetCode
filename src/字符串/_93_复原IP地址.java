package 字符串;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 93. 复原 IP 地址
给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。

有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址
 * */


/*IP地址由32位二进制数组成，为便于使用，常以XXX.XXX.XXX.XXX形式表现，
 * 每组XXX代表小于或等于255的10进制数。所以说IP地址总共有四段，每一段可能有一位，两位或者三位，范围是[0, 255]，
 * 题目明确指出输入字符串只含有数字，所以当某段是三位时，我们要判断其是否越界（>255)，
 * 还有一点很重要的是，当只有一位时，0可以成某一段，如果有两位或三位时，像 00， 01， 001， 011， 000等都是不合法的，
 * 所以我们还是需要有一个判定函数来判断某个字符串是否合法。这道题其实也可以看做是字符串的分段问题，
 * 在输入字符串中加入三个点，将字符串分为四段，每一段必须合法，求所有可能的情况。根据目前刷了这么多题，
 * 得出了两个经验， 一是只要遇到字符串的子序列或配准问题首先考虑动态规划DP，二是只要遇到需要求出所有可能情况首先考虑用递归 。
 * 这道题并非是求字符串的子序列或配准问题，更符合第二种情况，所以我们要用递归来解。我们用k来表示当前还需要分的段数，
 * 如果k = 0，则表示三个点已经加入完成，四段已经形成，若这时字符串刚好为空，则将当前分好的结果保存。若k != 0, 
 * 则对于每一段，我们分别用一位，两位，三位来尝试，分别判断其合不合法，如果合法，则调用递归继续分剩下的字符串，最终和求出所有合法组合
 * */
public class _93_复原IP地址 {
	public static List<String> restoreIpAddresses(String s) {
		List<String> list = new LinkedList<String>();
		Deque<String> path = new ArrayDeque<String>(4);
		if(s.length()<=3) return list;
		
		
		//backtracking(s,"",0,0,list);
		return list;
		
		
    }

	private static void helper(String s, int n, String out, List<String> list) {
		// TODO Auto-generated method stub
		if(n==4){
			if(s.isEmpty()) list.add(out);
			return;
		}
		
		for(int k=1;k<4;k++){
			if(s.length()<k) break;
			int val = Integer.parseInt(s.substring(0, k));
			if(val>255 || k !=String.valueOf(val).length()) continue;
			helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), list);
		}
	}
    
	
	
	public List<String> restoreIpAddresses2(String s) {
        int len = s.length();
        List<String> res = new ArrayList<String>();
        if (len > 12 || len < 4) {
            return res;
        }

        Deque<String> path = new ArrayDeque<String>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割

    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }

            if (residue * 3 < len - i) {
                continue;
            }

            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }


	public static void main(String[] args) {
		List<String> reStrings = restoreIpAddresses("25525511135");
		for(String s:reStrings){
			System.out.println(s);
		}
	}
	
	
	
	
}
