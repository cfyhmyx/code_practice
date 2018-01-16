//https://leetcode.com/problems/accounts-merge/description/

import java.util.*;

public class Leetcode721 {
    public static void main(String args[]) {

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailParentMap = new HashMap<>();
        Map<String, String> emailNameMap = new HashMap<>();
        Map<String, Integer> emailRankMap = new HashMap<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                if (!emailNameMap.containsKey(email)) {
                    emailNameMap.put(email, name);
                    emailRankMap.put(email, 0);
                }
                if(!emailParentMap.containsKey(email)) {
                    emailParentMap.put(email, email);
                }
                if (i != 1) {
                    union(email, acc.get(i-1), emailParentMap, emailRankMap);
                }
            }
        }
        Map<String, List<String>> rootEmailMap = new HashMap<>();
        for (String email : emailNameMap.keySet()) {
            String root = find(email, emailParentMap);
            if (!rootEmailMap.containsKey(root)) {
                rootEmailMap.put(root, new ArrayList<>());
            }
            rootEmailMap.get(root).add(email);
        }
        List<List<String>> resultList = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : rootEmailMap.entrySet()) {
            String root = entry.getKey();
            List<String> emailList = entry.getValue();
            Collections.sort(emailList);
            emailList.add(0, emailNameMap.get(root));
            resultList.add(emailList);
        }
        return resultList;
    }

    private String find(String s, Map<String, String> emailParentMap) {
        if(emailParentMap.get(s).equals(s)) {
            return s;
        }
        emailParentMap.put(s, find(emailParentMap.get(s), emailParentMap));
        return emailParentMap.get(s);
    }

    private void union(String email1, String email2, Map<String, String> emailParentMap, Map<String, Integer> emailRankMap) {
        String root1 = find(email1, emailParentMap);
        String root2 = find(email2, emailParentMap);
        if(root1.equals(root2)) return;
        int rank1 = emailRankMap.get(root1);
        int rank2 = emailRankMap.get(root2);
        if (rank1 < rank2) {
            emailParentMap.put(root1, root2);
        } else if (rank1 > rank2) {
            emailParentMap.put(root2, root1);
        } else {
            emailParentMap.put(root2, root1);
            emailRankMap.put(root1, rank1 + 1);
        }
    }
}
