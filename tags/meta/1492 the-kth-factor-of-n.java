/*
https://leetcode.com/problems/the-kth-factor-of-n/

只需要扫描到sqrt(n)即可，边扫描边把不相同的因数存到list中，因为因数可以成对出现
如果到sqrt(n)还没找到k个，那么就在list中反向的找剩下的即可

Time: O(sqrt(n))
Space: O(min(k, sqrt(n)))
*/

class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) return i;
                if (n / i != i) l.add(n / i);
            }
        }
        int size = l.size();
        if (size - k < 0) return -1;
        return l.get(size - k);
    }
}