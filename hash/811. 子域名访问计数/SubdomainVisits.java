import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class SubdomainVisits {
	public List<String> subdomainVisits(String[] cpdomains) {
		StringBuffer sb = new StringBuffer();
		Map<String, Integer> map = new HashMap<>();
		List<String> ret = new ArrayList<>();

		for (String domain : cpdomains) {
			char[] domainArray = domain.toCharArray();
			int start = 0;
			while (domainArray[start] != ' ') sb.append(domainArray[start++]);
			int times = Integer.valueOf(sb.toString());
			sb = new StringBuffer();

			int idx = domainArray.length - 1;
			while (idx > start) {
				while (idx > start && domainArray[idx] != '.') sb.append(domainArray[idx--]);
				StringBuffer temp = new StringBuffer(sb);
				String curr = temp.reverse().toString();
				if (!map.containsKey(curr)) map.put(curr, 0);
				map.put(curr, map.get(curr) + times);
				if (idx != domainArray.length) sb.append('.');
				idx--;
			}
			sb = new StringBuffer();
		}
		
		for (String s : map.keySet()) {
			ret.add(map.get(s) + " " + s);
		}

		return ret;
	}

	public static void main(String[] args) {
		SubdomainVisits sv = new SubdomainVisits();
		System.out.println(sv.subdomainVisits(new String[] {"9001 discuss.leetcode.com"}));
		System.out.println(sv.subdomainVisits(new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
	}
}