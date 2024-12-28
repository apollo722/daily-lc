/*
https://leetcode.com/problems/dota2-senate/

采用模拟的想法即可，即每次遇到R或者D，如果之前没有人ban掉，那就增加ban掉另一个的cnt，否则消耗一个对面ban的cnt
如此反复直到q中只含有一种字母

Time: O(n)
Space: O(n)
*/

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        for (char c : senate.toCharArray()) q.add(c);
        boolean hasD = true, hasR = true;
        int banD = 0, banR = 0;
        while (hasD && hasR) {
            hasD = false;
            hasR = false;
            int size = q.size();
            while (size-- > 0) {
                char c = q.poll();
                if (c == 'R') {
                    if (banR > 0) banR--;
                    else {
                        q.add('R');
                        banD++;
                        hasR = true;
                    }
                } else {
                    if (banD > 0) banD--;
                    else {
                        q.add('D');
                        banR++;
                        hasD = true;
                    }
                }
            }
        }
        return q.peek() == 'R' ? "Radiant" : "Dire";
    }
}