package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





/*
 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，
 下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，
 也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。

给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subdomain-visit-count
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * */
public class _811_子域名访问计数 {
	 public static List<String> subdomainVisits(String[] cpdomains) {
		 List<String> list = new ArrayList<String>();
		 Map<String, Integer> map = new HashMap<String, Integer>();
		 
		 for (int i = 0; i < cpdomains.length; i++) {
			 process(cpdomains[i],map);
		 }
		 
		 for(Map.Entry<String, Integer> entry:map.entrySet()) {
			 
			 String reString = entry.getValue() +" "+entry.getKey();
			 list.add(reString);
			 //System.out.println(entry.getKey()+"-->"+entry.getValue());
		 }
		 
		 
		 return list;
	 }

	private static void process(String string, Map<String, Integer> map) {
		int num = 0;
		int i = 0;
		for (; i < string.length(); i++) {
			char ch = string.charAt(i);
			if('0'<=ch&&ch<='9') {
				num = num*10+ch-'0';
			}else {
				break;
			}
		}
		i++;
	
		String s = string.substring(i,string.length());
		
		for (int j = 0; j<s.length() ; j++) {
			if(s.charAt(j)=='.') {
				String tmp = s.substring(j+1, s.length());
				//System.out.println(tmp+"--"+num);
				
				if(map.containsKey(tmp)) {
					int count = map.get(tmp);
					map.put(tmp, count+num);
				}else {
					map.put(tmp,num);
				}
			}
		}
		
		map.put(s, num);	
	}
	
	public List<String> subdomainVisits2(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }

	
	public static void main(String[] args) {
		String[] cpdomains = new String[] {"900 google.mail.com","50 yahoo.com",
				"1 intel.mail.com","5 wiki.org"};
		
		System.out.println(subdomainVisits(cpdomains));
	}
}
