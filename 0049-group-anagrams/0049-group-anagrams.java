class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            String ss = get(s);
            if (!m.containsKey(ss)) m.put(ss, new ArrayList<>());
            m.get(ss).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> e : m.entrySet()) {
            res.add(e.getValue());
        }
        return res;
    }

    private String get(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}