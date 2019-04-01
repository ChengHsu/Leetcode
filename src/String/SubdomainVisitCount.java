package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Number: #811. Subdomain Visit Count
 * @Descpription: A website domain like "discuss.leetcode.com" consists of various subdomains.
 * At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com".
 * When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received),
 * followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order),
 * that explicitly counts the number of visits to each subdomain.
 * @Author: Created by xucheng.
 */
public class SubdomainVisitCount {
    /**
     * Slow:
     * String[] arr = s.split(" ");
     * int visit = Integer.parseInt(arr[0]);
     * String domain = arr[1];
     *
     * Fast:
     * int index = s.indexOf(' ');
     * int visit = Integer.parseInt(s.substring(0, index));
     * String domain = s.substring(index + 1);
     *
     * time: O(n)
     * space: O(n)
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        if (cpdomains.length == 0)
            return ans;

        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int spaceIdx = cpdomain.indexOf(" ");
            int visits = Integer.parseInt(cpdomain.substring(0, spaceIdx));
            String domain = cpdomain.substring(spaceIdx + 1);
            map.put(domain, map.getOrDefault(domain, 0) + visits);
            for (int i = 0; i < domain.length(); i++) {
                System.out.println("domain: "+domain);
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    System.out.println(subdomain);
                    map.put(subdomain, map.getOrDefault(subdomain, 0) + visits);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            int totalVisits = entry.getValue();
            String subdomain = entry.getKey();
            System.out.println(totalVisits + " " + subdomain );
            sb.append(String.valueOf(totalVisits)).append(" ").append(subdomain);
            ans.add(sb.toString());
        }
        return ans;
    }

}
