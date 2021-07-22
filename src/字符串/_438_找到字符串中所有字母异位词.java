package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/*
 * 
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：
字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * */
public class _438_找到字符串中所有字母异位词 {
	 public static List<Integer> findAnagrams(String s, String p) {
		 List<Integer> list = new ArrayList<Integer>();
		 char[] count = new char[128];
		 int len1 = s.length();
		 int len2 = p.length();
		 System.out.println(p.toCharArray());
		 for(char c:p.toCharArray()) {
			 System.out.println(c);
			 count[c]++;
		 }
		 
		 for (int i = 0; i < count.length; i++) {
			System.out.print(count[i]+",");
		}
		 int i=0;
		 while(i<len1) {
			 boolean succ = true;
			 char[] tmp = Arrays.copyOf(count, 128);
			 for (int j = 0; j <i+len2; j++) {
				if(--tmp[s.charAt(i)]<0) {
					succ = false;
					break;
				}
			 }
			 if(succ) list.add(i);
			 
			 i++;
		 }
		 return list;
	 }
	 
	 
	 public static List<Integer> findAnagrams2(String s, String p) {
		 int[] fre = new int[26];
         //表示窗口内相差的字符的数量
         int dif = 0; 
         // fre 统计频数
         for (char c :p.toCharArray()) {
             fre[c - 'a']++;
             dif++;
         }
         
         int left=0,right=0;
         int length = s.length();
         char[] array = s.toCharArray();
         
         List<Integer> result = new ArrayList<>();
         
         
         while (right < length) {
             char rightChar = array[right];                         
             //是p中的字符  
             if (fre[rightChar-'a'] > 0) {
                 fre[rightChar-'a']--;
                 //差距减少
                 dif--;
                 right++;

                 //差距减少为0时 说明窗口内为所求
                 if (dif == 0) {
                     result.add(left);
                 }
             }else{
                 //俩种情况 ：
            	 //第一种 rightChar 是p以外的字符串如"c" "abc" "ab" 此时 left 和 right 都应该指向 c后面的位置   
                 //第二种 rightChar是p内的字符串但是是额外的一个char如第二个"b" 例 "abb" "ab" 此时right不变 
            	 //left应该指向第一个b后面的位置
     
                 //对于第一种情况 left 和 right 都应该定位到 c  所以要恢复fre数组 同时恢复差距
                 //对于第二种情况 此时fre[array[right]-'a']=0 让left移动到第一个b后面的位置 这样就融入了新的b（第二个b）
                 
                 while (fre[array[right]-'a']<=0 && left<right) {
                     fre[array[left]-'a']++;
                     left++;
                     dif++;
                 }
                 if (left == right ) {                     
                     //这个if用来检测right所处字符是否是p外的字符
                     //用来处理第二种情况 
                     if (fre[array[left] - 'a'] > 0) {
                         //说明是p里的字符 跳过
                         continue;
                     }else{
                     //用来处理第一种情况 移动到这个字符后面的位置
                         left++;
                         right++;
                     }

                 }
             }
         }

         return result;
	 }
	
	 
	 public static void main(String[] args) {
		String pString = "abc";
		String  string = "cbaebabacd";
		List<Integer> list  = findAnagrams2(string, pString);
		System.out.println(list);
		for (int a:list) {
			System.out.println(a);
		}
	}
}
