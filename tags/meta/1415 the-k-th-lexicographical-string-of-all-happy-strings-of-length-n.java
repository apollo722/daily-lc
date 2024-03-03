/*
https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

没有好的算法，只能backtrack把所有组合求出来取第k个

Time: O(3*2^(n-1))
Space: O(n)
*/

class Solution {
    public String getHappyString(int n, int k) {
        char[] arr = {'a', 'b', 'c'};
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), arr, n);
        return k > res.size() ? "" : res.get(k - 1);
    }

    private void backtrack(List<String> res, StringBuilder cur, char[] arr, int tar) {
        if (cur.length() == tar) {
            res.add(cur.toString());
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (cur.length() == 0 || cur.charAt(cur.length() - 1) != arr[i]) {
                cur.append(arr[i]);
                backtrack(res, cur, arr, tar);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}