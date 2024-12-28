/*
https://leetcode.com/problems/jewels-and-stones/

代码题

Time: O(m + n)
Space: O(m)
*/

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            set.add(c);
        }
        int res = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) res++;
        }
        return res;
    }
}