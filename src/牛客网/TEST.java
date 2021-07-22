package 牛客网;

import java.util.Arrays;

public class TEST {
	public static int Minimumdays (int n, int[] DEF) {
        // write code here
		
		if(DEF.length==0) return 0;
		Arrays.sort(DEF);
		
		int days = DEF[0];
		int maxkill = DEF[0];
		
		for (int i = 1; i < DEF.length; i++) {
			if(DEF[i]>maxkill){
				days+=DEF[i]-maxkill;
				maxkill = days;
			}else {
				days+=1;
				maxkill = days;
			}
			
		}
		return days;
    }
	
	 public static long cnt_3(long x){
	        if(x==0) return 1;
	        else if(x==1) return 15;
	        long ans=cnt_3(x/2);
	        ans=(ans*ans)%1000000007;
	        if(x%2==1) ans=(ans*15)%1000000007;
	        return ans;
	  }
	    
    public static int Answerforcn (long n){
        // write code here
        long res;
        res=(14*cnt_3(n-1)%1000000007);
        return (int)res;
    }
    
    
    

	
	public static void main(String[] args) {
		int[] DEF = {7,3};
		int day = Minimumdays(2, DEF);
		System.out.println(day);
	}
}
