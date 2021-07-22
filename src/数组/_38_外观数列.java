package 数组;

/*
 给定一个正整数 n ，输出外观数列的第 n 项。
「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
你可以将其视作是由递归公式定义的数字字符串序列：
countAndSay(1) = "1"
countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-and-say
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class _38_外观数列 {
	public String countAndSay(int n) {
		 String arr = "1"; // 首先初始化一个储存结果的数组
	        if(n == 1) //n==1为特例
	            return arr;

	        // 第1层循环，循环中的第i次将生成 n=i+1 时的外观数列
	        for(int i=1 ; i<n ; i++) //注意，i从1开始循环，因为n==1的情况已经单独判断了
	        {
	            char word = arr.charAt(0); //word代表当前被搜查的数字
	            int num = 1; //(计数器)num代表当前被搜查的数字在当前arr序列中出现的个数，已经发现这个数字了，所以num先置1
	            
	            String temp = ""; //temp为存储新生成序列的字符串

	            // 第2层循环，循环中的第j次将扫描元素arr[j]
	            for(int j=1 ; j<arr.length() ; j++) //因为arr[0]已经搜过了，所以j从1开始
	            {
	                if(word == arr.charAt(j)) //如果arr[j]==当前被搜寻的数字word，则计数器num加1
	                {
	                    num++;
	                }
	                else if(word != arr.charAt(j)) //如果word != arr[j]，说明word数字子串已经结束了，出现了新的数字
	                {
	                    char num_char = (char) (num + '0');
	                    temp += num_char; //将个数加入新序列中
	                    temp += word; //将被搜寻数字也加入新序列中

	                    word = arr.charAt(j); //reset 将word设为新的被搜寻数字
	                    num = 1; //reset
	                }
	            }
	            // 边界处理
	            // 注意，上面的循环结束后，旧序列中排在最后一个的数字虽然被搜到了，但并没有被加入到新序列中，因此要把它也补进去
	            char num_char = (char) (num + '0');  
	            temp += num_char;
	            temp += word;
	            arr = temp; //将新生成的序列赋给arr
	        }
	        return arr;

    }
}
