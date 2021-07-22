package 查找;

/*
 *传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
传送带上的第 i 个包裹的重量为 weights[i]。
每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 参考
 * https://github.com/grandyang/leetcode/issues/1011
 * */
public class _1011_在D天内送达包裹的能力 {
	public static int shipWithinDays(int[] weights, int D) {
		int left = 0,right = 0;
		// 挑选出货物的最大值，应为轮船的载重至少为最大值,最大值为所有货物的总质量
		//轮船的载重必定在这两者之间
		for (int i = 0; i < weights.length; i++) {
			left = Math.max(left, weights[i]);
			right+=weights[i];
		}
		
		while (left<right) {
			int mid = (left+right)/2;
			int need_days = 1; // 需要的天数
			int cur_good = 0; //当前货物的重量
			
			for(int weight:weights) {
				cur_good+=weight;
				if(cur_good>mid) {
					cur_good = weight; // 重置货物载重
					need_days++;
				}
			}
			
			//for循环出来以后就可以算出以mid为载重的need——days
			if(need_days>D) {
				left = mid+1;
			}else {
				right = mid;
			}
			
		}
		return left;
    }
	
	
	public static void main(String[] args) {
		//1,2,3,4,5,6,7,8,9,10
		//3,2,2,4,1,4
		int[] weights = new int[]{3,2,2,4,1,4};
		int days = 3;
		System.out.println(shipWithinDays(weights,days));
		
	}
}
