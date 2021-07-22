package 数组;

public class _010_数组左边小中间相等右边大 {
	public int[] partition(int arr[],int L,int R,int p) {
		
		int less = L-1;
		int more = R+1;
		//int num = arr[arr.length-1];
		while (L<more) {
			if(arr[L]<p){
				swap(arr, ++less, L++);
			}else if(arr[L]>p){
					swap(arr,--more, L);
			}else{
				L++;
			}
			
		}

		return arr;
	}
	
	public static void swap(int[] arr, int i, int j) {
//		arr[i] = arr[i] ^ arr[j];
//		arr[j] = arr[i] ^ arr[j];
//		arr[i] = arr[i] ^ arr[j];
		int tmp;
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
