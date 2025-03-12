class WordDistance {
    HashMap<String, List<Integer>> m = new HashMap<>();
    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            String cur = wordsDict[i];
            if (!m.containsKey(cur)) {
                m.put(cur, new ArrayList<>());
            }
            m.get(cur).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = m.get(word1), l2 = m.get(word2);
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        while (i < l1.size() && j < l2.size()) {
            int p1 = l1.get(i), p2 = l2.get(j);
            res = Math.min(res, Math.abs(p1 - p2));
            if (p1 < p2) i++;
            else j++;
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */