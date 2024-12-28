/*
https://leetcode.com/problems/group-anagrams/

对每个str进行排序后放入map即可
也可以记录每个str字符出现频率，利用频率concat的str作为key来记录
这样可以达到O(nk)

Time: O(nklogk)，k为单词平均长度
Space: O(nk)
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String k = new String(arr);
            if (!m.containsKey(k)) m.put(k, new ArrayList<>());
            m.get(k).add(s); 
        }
        List<List<String>> res = new ArrayList<>();
        for (String k : m.keySet()) res.add(m.get(k));
        return res;
    }
}