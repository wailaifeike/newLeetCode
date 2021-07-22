package 贪心算法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/*
假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。

请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _406_根据身高重建队列 {
	 public static int[][] reconstructQueue(int[][] people) {
		 
		 Arrays.sort(people, new Comparator<int[]>() {
			 public int compare(int[] p1,int[] p2) {
				 if(p1[0]!=p2[0]) {
					 return p1[0]-p2[0];
				 }else {
					return p2[1] - p1[1];
				}
			 }
			 
		 });
		 
		 for (int[] peo:people) {
				System.out.print("["+peo[0]+","+peo[1]+"]"+",");
				
		 }
		 System.out.println();
		 
		 int[][] queue = new int[people.length][];
		 
		 for (int[] person:people) {
			int space = person[1]+1; //表示当前位置需要有多少个人需要安排位置个数
			for (int i = 0; i < queue.length; i++) {
				if(queue[i]==null) {
					--space;
					if(space==0) {
						queue[i] = person;
					}
				}
			}
			
		}
		 
		 return queue;
	 }
	 
	 
	public static void main(String[] args) {
		//[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]
		int[][] people = new int[][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] res = reconstructQueue(people);
		for (int[] peo:res) {
			System.out.print("["+peo[0]+","+peo[1]+"]"+",");
			
		}
		
	}
}
