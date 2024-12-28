/*
https://leetcode.com/problems/integer-to-roman/

顺序处理每一位，从个位，十分位，一直到千分位
每次根据此时对10的余数来决定应该attach什么到结果
也取决于当时在哪位
最后反置结果即可

Time: O(1)，题目的num有上限
Space: O(1)
*/

class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> m = new HashMap<>();
        m.put(1, "I");
        m.put(5, "V");
        m.put(10, "X");
        m.put(50, "L");
        m.put(100, "C");
        m.put(500, "D");
        m.put(1000, "M");
        StringBuilder res = new StringBuilder();
        int cur = 1;
        while (num > 0) {
            int d = num % 10;
            if (d > 0 && d <= 3) {
                while (d-- > 0) res.append(m.get(cur));
            } else if (d == 4) {
                res.append(m.get(5 * cur));
                res.append(m.get(cur));
            } else if (d == 5) res.append(m.get(5 * cur));
            else if (d > 5 && d <= 8) {
                while (d-- > 5) res.append(m.get(cur));
                res.append(m.get(5 * cur));
            } else if (d == 9) {
                res.append(m.get(10 * cur));
                res.append(m.get(cur));
            }
            cur *= 10;
            num /= 10;
        }
        return res.reverse().toString();
    }
}