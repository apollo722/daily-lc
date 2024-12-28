/*
https://leetcode.com/problems/fizz-buzz/

按题意判断，先判断同时能被3与5整除的，再判断其它情况

Time: O(n)
Space: O(1)
*/

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) res.add("FizzBuzz");
            else if (i % 3 == 0) res.add("Fizz");
            else if (i % 5 == 0) res.add("Buzz");
            else res.add(String.valueOf(i));
        }
        return res;
    }
}