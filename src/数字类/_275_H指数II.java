package 数字类;

public class _275_H指数II {
	public int hIndex(int[] citations) {
		 int len = citations.length, left = 0, right = len - 1;
	        while (left <= right) {
	            int mid = (int) (0.5 * (left + right));
	            if (citations[mid] == len - mid) return len - mid;
	            else if (citations[mid] > len - mid) right = mid - 1;
	            else left = mid + 1;
	        }
	     return len - left;
    }
}
