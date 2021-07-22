package 牛客网;

public class NC88数组中第K大的数 {
	 public static int findKth(int[] a, int n, int K) {
	       
	    
	       return KthElement(a,0,a.length-1,n,K);
	 }
	 
	 public static int KthElement(int[] arr,int low, int high,int n ,int k)
	 {
	     if(arr == null || low >= high || k > n)//边界条件和特殊输入的处理
	         return 0;
	     int pos = partition(arr,low,high);
	     while(pos != n  - k)
	     {
	         if(pos > n - k)
	         {
	             high = pos - 1;
	             pos = partition(arr,low,high);
	         }
	         if(pos < n - k)
	         {
	             low = pos + 1;
	             pos = partition(arr,low,high);
	         }
	     }
	     return arr[pos];
	  
	 }
	 
	 
	 public static int partition(int[] arr,int low ,int high) {
		 int temp = arr[low];
		    while(low < high)
		    {
		        while(low < high && arr[high] >= temp)
		            high--;
		        arr[low] = arr[high];
		        while(low < high && arr[low] <= temp)
		            low++;
		        arr[high] = arr[low];
		    }
		    arr[low] = temp;//确定参考元素的位置
		    return low;
	
	 }
	 
	 
	 public static int[] generateRandomArray(int maxSize, int maxValue) {
			int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int) ((maxValue + 1) * Math.random());
			}
			return arr;
	 }
	 
	 
	 public static void main(String[] args) {
		 int[] arr = generateRandomArray(10, 10);
		 for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		 }
		 
		 System.out.println();
		 
		 int k=2;
		 int result = findKth(arr,arr.length,k);
		 
		 System.out.println("第"+k+"大的数为:"+result);
		 
		 
	}

}
