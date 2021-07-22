package 数组;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/*
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。

 

示例 1：

输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
输出：13
解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _378_有序矩阵中第K小的元素 {
	
	public static class Node {
		public int value;
		public int row;
		public int col;

		public Node(int v, int r, int c) {
			value = v;
			row = r;
			col = c;
		}

	}

	public static class NodeComparator implements Comparator<Node> {

		public int compare(Node o1, Node o2) {
			return o1.value - o2.value;
		}

	}
	
	
	public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
    
    
    public static int kthSmallest1(int[][] matrix, int k) {
		int N = matrix.length;
		int M = matrix[0].length;
		PriorityQueue<Node> heap = new PriorityQueue<Node>(new NodeComparator());
		boolean[][] set = new boolean[N][M];
		heap.add(new Node(matrix[0][0], 0, 0));
		set[0][0] = true;
		int count = 0;
		Node ans = null;
		while (!heap.isEmpty()) {
			ans = heap.poll();
			if (++count == k) {
				break;
			}
			int row = ans.row;
			int col = ans.col;
			if (row + 1 < N && !set[row + 1][col]) {
				heap.add(new Node(matrix[row + 1][col], row + 1, col));
				set[row + 1][col] = true;
			}
			if (col + 1 < M && !set[row][col + 1]) {
				heap.add(new Node(matrix[row][col + 1], row, col + 1));
				set[row][col + 1] = true;
			}
		}
		return ans.value;
	}
    
    public static abstract class IntComparator implements Comparator<Integer> {

		public int compare(int a, int b) {
			return a-b;
		}


	}
    
  
    //利用多路归并排序的思路
    public int kthSmallest3(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }


    
    

    

}
