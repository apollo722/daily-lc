/*
https://leetcode.com/problems/accounts-merge/

标准union find
先把每个account标号，之后根据每个email对标号的map，进行union
之后再利用union好的组，来将所有email分组，并在分组的时候利用treeset排序
最后根据组号找到account name之后build结果

Time: O(nklog(nk))，n为accounts数，k为max account length
Space: O(nk)
*/

class Solution {
    int[] id, sz;

    private int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    private void union(int p, int q) {
        int pId = find(p), qId = find(q);
        if (pId == qId) return;
        if (sz[pId] < sz[qId]) {
            sz[qId] += sz[pId];
            id[pId] = qId;
        } else {
            sz[pId] += sz[qId];
            id[qId] = pId;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        Map<String, Integer> emailMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> emails = accounts.get(i);
            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                if (!emailMap.containsKey(email)) emailMap.put(email, i);
                else union(i, emailMap.get(email));
            }
        }
        Map<Integer, TreeSet<String>> groupId = new HashMap<>();
        for (Map.Entry<String, Integer> e : emailMap.entrySet()) {
            int pId = find(e.getValue());
            if (!groupId.containsKey(pId)) groupId.put(pId, new TreeSet<>());
            groupId.get(pId).add(e.getKey());
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> g : groupId.entrySet()) {
            int pId = g.getKey();
            TreeSet<String> s = g.getValue();
            List<String> l = new ArrayList<>();
            l.add(accounts.get(pId).get(0));
            l.addAll(s);
            res.add(l);
        }
        return res;
    }
}