package 字符串;

/*
 * 给你一个字符串 s ，一个分割被称为 
 * 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
请你返回 s 中好分割的数目。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-good-ways-to-split-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 */
public class _1525_字符串的好分割数目 {
	
	//滑动窗口
	public int numSplits(String s) {
		
		  int size = 26;
	        int[] leftCount = new int[size];
	        int[] rightCount = new int[size];
	        int leftVaild = 0;
	        int rightVaild = 0;
	        //先将整个字符串作为右半部分滑窗的内容
	        for(char ch : s.toCharArray()){
	            int num = ch - 'a';
	            if(rightCount[num] == 0){
	                rightVaild++;
	            }
	            rightCount[num]++;
	        }

	        int c = 0;
	        //慢慢调整左半部分滑窗，从左往右遍历，增大左半部分，缩减右半部分，进行滑窗
	        for(char ch : s.toCharArray()){
	            int num = ch - 'a';
	            //左边没有出现过这种字符，那么左边字符 +1
	            if(leftCount[num] == 0){
	                leftVaild++;
	            }
	            //右边这是最后一次出现该字符，那么滑窗后右边字符 -1，即这种字符不会再出现在右边了
	            if(rightCount[num] == 1){
	                rightVaild--;
	            }
	            leftCount[num]++;
	            rightCount[num]--;
	            if(leftVaild == rightVaild){
	                c++;
	            }
	        }
	        return c;

    }
	
	//动态规划
	public int numSplits2(String s) {
        int n = s.length();
        int[] left = new int[n + 2];
        int[] right = new int[n + 2];
        boolean[] recLeft = new boolean[26];
        boolean[] recRight = new boolean[26];
        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';
            if (recLeft[c]) {
                left[i] = left[i - 1];
            } else {
                recLeft[c] = true;;
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n; i > 0; i--) {
            int c = s.charAt(i - 1) - 'a';
            if (recRight[c]) {
                right[i] = right[i + 1];
            } else {
                recRight[c] = true;
                right[i] = right[i + 1] + 1;
            }
        }
        int ret = 0;
        for (int i = 1; i < n; i++) {
            if (left[i] == right[i + 1]) {
                ret++;
            }
        }
        return ret;
    }
}
