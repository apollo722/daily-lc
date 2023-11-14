/*
https://leetcode.com/problems/valid-parenthesis-string/

正反分别扫两次
如果balance为0且也没有多余的*，即返回false
否则消耗*

有只扫一遍的greedy算法： 
Intuition

When checking whether the string is valid, we only cared about the "balance": the number of extra, open left brackets as we parsed through the string. 
For example, when checking whether '(()())' is valid, we had a balance of 1, 2, 1, 2, 1, 0 as we parse through the string: '(' has 1 left bracket, '((' has 2, '(()' has 1, and so on. This means that after parsing the first i symbols, (which may include asterisks,) we only need to keep track of what the balance could be.

For example, if we have string '(***)', then as we parse each symbol, the set of possible values for the balance is [1] for '('; [0, 1, 2] for '(*'; [0, 1, 2, 3] for '(**'; [0, 1, 2, 3, 4] for '(***', and [0, 1, 2, 3] for '(***)'.

Furthermore, we can prove these states always form a contiguous interval. 
Thus, we only need to know the left and right bounds of this interval. 
That is, we would keep those intermediate states described above as [lo, hi] = [1, 1], [0, 2], [0, 3], [0, 4], [0, 3].

Algorithm

Let lo, hi respectively be the smallest and largest possible number of open left brackets after processing the current character in the string.

If we encounter a left bracket (c == '('), then lo++, otherwise we could write a right bracket, so lo--. 
If we encounter what can be a left bracket (c != ')'), then hi++, otherwise we must write a right bracket, so hi--. 
If hi < 0, then the current prefix can't be made valid no matter what our choices are. 
Also, we can never have less than 0 open left brackets. At the end, we should check that we can have exactly 0 open left brackets.

class Solution {
    public boolean checkValidString(String s) {
       int lo = 0, hi = 0;
       for (char c: s.toCharArray()) {
           lo += c == '(' ? 1 : -1;
           hi += c != ')' ? 1 : -1;
           if (hi < 0) break;
           lo = Math.max(lo, 0);
       }
       return lo == 0;
    }
}

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean checkValidString(String s) {
        int curStar = 0, balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            else if (c == ')') {
                if (balance == 0 && curStar == 0) return false;
                else if (balance == 0 && curStar > 0) {
                    curStar--;
                } else balance--;
            } else curStar++;
        }
        if (balance > curStar) return false;
        balance = 0;
        curStar = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') balance++;
            else if (c == '(') {
                if (balance == 0 && curStar == 0) return false;
                else if (balance == 0 && curStar > 0) {
                    curStar--;
                } else balance--;
            } else curStar++;
        }
        return true;
    }
}