/*
https://leetcode.com/problems/bulls-and-cows/

扫一遍输入，同样位置的记录下来个数，并记录下每个数字出现的个数差
最后扫一遍map，记录下频率为正数的总数，证明这数字有但是没有被猜到
那么剩下的总长减去没被猜到的再减掉match的个数即为猜到但位置不对的

也可以不额外扫描频率map
扫描输入，每次相同位置相同字符，A++
否则，把s的字符在在map中++，g的字符在map中--
如果每次扫描到s和g中字符，如果此时s的字符在map中频率小于零，或者g的字符在map中大于零
即证明之前的某一时刻互相有match到对方，那么B++

class Solution {
    public String getHint(String secret, String guess) {
        int[] m = new int[10]; 
        int A = 0, B = 0, n = guess.length();
        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                A++;    
            } else {
                if (m[s - '0'] < 0) B++;
                if (m[g - '0'] > 0) B++;
                m[s - '0']++;
                m[g - '0']--;
            }
        } 
        StringBuilder sb = new StringBuilder();
        sb.append(A); 
        sb.append("A"); 
        sb.append(B); 
        sb.append("B");
        return sb.toString();
    }
}

Time: O(n)
Space: O(1)
*/

class Solution {
    public String getHint(String secret, String guess) {
        int countA = 0, countB = 0;
        int[] m = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) countA++;
            m[secret.charAt(i) - '0']++;
            m[guess.charAt(i) - '0']--;
        }
        int n = secret.length();
        int total = 0;
        for (int num : m) if (num > 0) total += num;
        countB = n - total - countA;
        return countA + "A" + countB + "B";
    }
}