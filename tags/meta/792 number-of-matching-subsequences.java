/*
https://leetcode.com/problems/number-of-matching-subsequences/

将每个字符的idx都存起来
扫描每一个单词的每一个字符，每次从对应的字符list中二分查找大于上一个位置的元素位置
直到找全或者找不到，找全的就结果++

Time: O(n + mlogn)，m为words中str总长
Space: O(n)
*/

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        List<List<Integer>> idxList = new ArrayList<>();
        for (int i = 0; i < 26; i++) idxList.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            idxList.get(c - 'a').add(i);
        }
        int res = 0;
        for (String w : words) {
            int prev = -1;
            boolean flag = true;
            for (char c : w.toCharArray()) {
                int idx = search(idxList.get(c - 'a'), prev);
                if (idx == -1) {
                    flag = false;
                    break;
                }
                prev = idxList.get(c - 'a').get(idx);
            }
            if (flag) res++;
        }
        return res;
    }

    private int search(List<Integer> arr, int tar) {
        if (arr.size() == 0) return -1;
        int l = 0, r = arr.size() - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) <= tar) l = mid + 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }
}