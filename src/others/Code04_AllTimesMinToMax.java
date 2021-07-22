package others;

public class Code04_AllTimesMinToMax {
	public static int max1(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int minNum = Integer.MAX_VALUE;
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
					minNum = Math.min(minNum, arr[k]);
				}
				max = Math.max(max, minNum * sum);
			}
		}
		return max;
	}
	
	public static int[] gerenareRondomArray() {
		int[] arr = new int[(int) (Math.random() * 20) + 10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 101);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = gerenareRondomArray();
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]+",");
		}
		
		System.out.println();
		int result = max1(arr);
		System.out.println(result);
		
	}
}
