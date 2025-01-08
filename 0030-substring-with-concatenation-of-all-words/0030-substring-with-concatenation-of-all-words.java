class Solution {
    HashMap<String, Integer> wordCount = new HashMap<>();
    int totalLen = 0, len = 0, totalCnt = 0;
    public List<Integer> findSubstring(String s, String[] words) {
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }
        len = words[0].length();
        totalLen = words.length * len;
        totalCnt = words.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            check(i, s, res);
        }
        return res;
    }

    private void check(int l, String s, List<Integer> res) {
        HashMap<String, Integer> found = new HashMap<>();
        int r = l, cnt = 0;
        while (r <= s.length() - len) {
            String cur = s.substring(r, r + len);
            if (!wordCount.containsKey(cur)) {
                found.clear();
                cnt = 0;
                l = r + len;
                r += len;
                continue;
            } 
            found.put(cur, found.getOrDefault(cur, 0) + 1);
            if (found.get(cur) <= wordCount.get(cur)) cnt++;
            while (cnt == totalCnt || found.get(cur) > wordCount.get(cur)) {
                if (cnt == totalCnt) {
                    res.add(l);
                }
                String left = s.substring(l, l + len);
                found.put(left, found.get(left) - 1);
                if (found.get(left) < wordCount.get(left)) cnt--;
                l += len;                
            }
            r += len;
        }
        return;
    }
}