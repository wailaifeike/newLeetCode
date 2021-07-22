package 数组;

public class Test {

	public static void main(String[] args) {
        _26_删除排序数组中的重复项 s  = new _26_删除排序数组中的重复项();
		int[] nums = new int[]{0,3,6,7,5,1,2,4,4,2};	
		_010_数组左边小中间相等右边大  test = new _010_数组左边小中间相等右边大();
		
		int[] newarr = test.partition(nums,2,nums.length-1,4);
		
		for (int i = 0; i < newarr.length; i++) {
			System.out.print(newarr[i]+" ,");
		}

	}

}
