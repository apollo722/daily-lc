/*
https://leetcode.com/problems/strobogrammatic-number-ii/

BFS思路，以可反转的数为中心，逐渐往外加可反转的数
n是偶数的时候即从空str开始
逐个扩大直到长度达到n

Time: O(n 5^((n/2)+1))
Space: O(n 5^((n/2)+1))
*/

class Solution {
    public char[][] candidates = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    
    public List<String> findStrobogrammatic(int n) {
        Queue<String> q = new LinkedList<>();
        int curLen;
        
        if (n % 2 == 0) {
            curLen = 0;
            q.add("");
        } else {
            curLen = 1;
            q.add("0");
            q.add("1");
            q.add("8");
        }
        
        while (curLen < n) {
            curLen += 2;
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();           
                for (char[] pair : candidates) {
                    if (curLen < n || pair[0] != '0') {
                        q.add(pair[0] + cur + pair[1]);
                    }
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        
        return res;
    }
}