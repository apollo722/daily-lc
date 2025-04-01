class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            map.put(sb.reverse().toString(), i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String curS = words[i];
            if (curS.length() == 0) {
                for (String s : map.keySet()) {
                    if (map.get(s) != i && check(s)) {
                        List<Integer> l1 = Arrays.asList(i, map.get(s));
                        List<Integer> l2 = Arrays.asList(map.get(s), i);
                        res.add(l1);
                        res.add(l2);
                    }
                }
            } else {
                if (map.containsKey(curS) && map.get(curS) != i) {
                    List<Integer> l = Arrays.asList(i, map.get(curS));
                    res.add(l);
                }
                for (int j = 0; j < curS.length(); j++) {
                    String left = curS.substring(0, j), right = curS.substring(j, curS.length());
                    // left: "" -> curS, right: curS -> "";
                    if (left.length() == 0 || right.length() == 0) continue;
                    if (check(left) && map.containsKey(right) && map.get(right) != i) {
                        List<Integer> l = Arrays.asList(map.get(right), i);
                        res.add(l);
                    }
                    if (check(right) && map.containsKey(left) && map.get(left) != i) {
                        List<Integer> l = Arrays.asList(i, map.get(left));
                        res.add(l);
                    }
                }
            }
        }
        return res;
    }

    private boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}