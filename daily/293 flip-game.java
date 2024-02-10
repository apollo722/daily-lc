/*
https://leetcode.com/problems/flip-game/

扫描每对相邻位置，如果是'+'，就进行转换，拼接，并置入结果

Time: O(n^2)
Space: O(1)
*/

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < currentState.length(); i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i - 1) == '+') {
                res.add(currentState.substring(0, i - 1) + "--" + currentState.substring(i + 1));
            }
        }
        return res;
    }
}