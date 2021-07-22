package 动态规划;

public class 背包问题 {
	public static int getMaxValue(int[] V,int[] W,int bag){
		
		return Process(V,W,0,bag);
	}

	private static int Process(int[] v, int[] w, int index, int rest) {
		// TODO Auto-generated method stub
		if(rest<0) return -1; //空间不足，此种方案无效
		if(index==w.length) return 0;
		
		int p1 = Process(v, w, index+1, rest); //不要当前index货物
		
		int p2 = -1;
		int p2next = Process(v, w, index+1, rest-w[index]);
		if(p2next!=-1){
			p2  = v[index] + p2next;
		}
		
		return Math.max(p1, p2);
	}
	
	public static void main(String[] args) {
		int[] w = { 0 , 2 , 3 , 4 , 5 };			//商品的体积2、3、4、5
		int[] v = { 0 , 3 , 4 , 5 , 6 };			//商品的价值3、4、5、6
		int bagV = 8;					        //背包大小
		
		int result = getMaxValue(v, w, bagV);
		System.out.println("最大价值为："+result);
	}
}
