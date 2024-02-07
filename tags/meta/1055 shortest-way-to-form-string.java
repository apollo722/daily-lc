/*
https://leetcode.com/problems/shortest-way-to-form-string/

将source每一个字符的idx存到对应字符的list中
之后扫描每个target的字符，并在对应字符的map中进行idx的二分查找，找到第一个大于当前idx的idx
如果没有的话，res就要++，并且idx置于当前list的头部
如果list本身是空，证明source中没有这个字符，直接返回-1

也有提前存储idx而不用二分查找的方法：https://leetcode.com/problems/shortest-way-to-form-string/editorial/

Time: O(s + tlog(s))
Space: O(s)
*/

class Solution {
    public int shortestWay(String source, String target) {
        int res = 1;
        List[] m = new List[26];
        for (int i = 0; i < 26; i++) m[i] = new ArrayList<>();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            m[c - 'a'].add(i);
        }
        int cur = -1;
        for (char c : target.toCharArray()) {
            List<Integer> list = m[c - 'a'];
            if (list.size() == 0) return -1;
            cur = find(list, cur);
            if (cur == -1) {
                res++;
                cur = list.get(0);
            }
        }
        return res;
    }

    private int find(List<Integer> list, int tar) {
        int l = 0, r = list.size() - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) <= tar) l = mid + 1;
            else {
                res = list.get(mid);
                r = mid - 1;
            }
        }
        return res;
    }
}