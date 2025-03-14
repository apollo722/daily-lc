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


/*
朴素的做法就是检查每一个位置-位置+字符串总长，看是否包含全部单词。利用map记录辅助检查。
但这样相当于每个位置都要检查所有单词，如果有很长的重复，比如'aaaaa'，单词是['a']，就会超时。
所以要利用sliding window，检查每一个word len的字符段，来看是否满足了words list中的要求。
滑动窗口部分比较朴素，和其他的题目的写法一样。
需要注意的是如果一个word不在需要的字典里，那么应该直接跳过这个word重新计算，因为任何包括这个word的substring都一定是不合法的。
但这样跳过也会有一个问题，就是跳的太多，万一这个word的某一个位置之后有在字典里的单词，那么就会错过。
所以滑动窗口要从s的每一个字符位置滑一次，直到单个word len位置，这样能cover不同位置起始的单词。
只要滑动word len次就够了，这是因为每次滑动窗口都是以len为单位滑动的，所以超过word len的部分实际上已经被前面的滑动cover了。
*/