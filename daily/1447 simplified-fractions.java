/*
https://leetcode.com/problems/simplified-fractions/

能放到结果中的一定是最大公约数为1的
用辗转相除法求出每一对数的最大公约数即可

Time: O(?)
Space: O(1)
*/

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    res.add(j + "/" + i);
                }
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return a % b == 0 ? b : gcd(b, a % b);
    }
}