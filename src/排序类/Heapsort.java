package 排序类;

public class Heapsort {
	public static void Heap(int[] arr){
		if(arr==null || arr.length<2) return;
		int k=4;
		int count = 0;
		while (k>0) {
			for (int i = 0; i < arr.length-count; i++) {
				heapInsert(arr,i);
			}
			swap(arr, 0, arr.length-1-count);
			count++;
			k--;
		}
		System.out.println(arr[arr.length-count]);
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i]+",");
//		}
	}

	public static void heapInsert(int[] arr, int i) {
		while(arr[i]>arr[(i-1)/2]){ // 子节点比父节点要大
			swap(arr,i,(i-1)/2);
			i = (i-1)/2;
		}	
	
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
		Heap(arr);
	}
}
