/*
https://leetcode.com/problems/lexicographical-numbers/

dfs可以用O(n)时间，O(log(len(n)))的空间复杂度来求解
即每次都先走深度(x10)，再走同层(+1)

如果用iterative的方式，也是一样的逻辑
先走深度，即如果cur*10还在范围内，那就*10
否则看+1是不是在范围，如果是的话那就+1，但是只能加到当前数位是9，不能进位
如果走不下去了，那就找到前一位不是9的那一位，之后从它开始+1，并继续上述逻辑

Time: O(n)
Space: O(1)
*/

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            calc(i, res, n);
        }
        return res;
    }

    private void calc(int i, List<Integer> res, int n) {
        if (i > n) return;
        res.add(i);
        for (int j = 0; j <= 9; j++) {
            if (i * 10 + j > n) break;
            calc(i * 10 + j, res, n);
        }
    }
}

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        for (int i = 0; i < n; i++) {
            res.add(cur);
            if (cur * 10 <= n) {
                cur *= 10;
            } else if (cur % 10 != 9 && cur + 1 <= n) {
                cur++;
            } else {
                while ((cur / 10) % 10 == 9) {
                    cur /= 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return res;
    }
}