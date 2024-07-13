/*
https://leetcode.com/problems/robot-collisions/

先要按照index的顺序排序，从左到右处理，剩下的和陨石撞击那道题一样

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] idx = new Integer[n];
        List<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);
        for (int i : idx) {
            if (directions.charAt(i) == 'R') st.push(i);
            else {
                while (!st.isEmpty() && healths[i] > 0) {
                    int top = st.pop();
                    if (healths[top] > healths[i]) {
                        healths[top] -=1;
                        healths[i] = 0;
                        st.push(top);
                    } else if (healths[top] < healths[i]) {
                        healths[i] -= 1;
                        healths[top] = 0;
                    } else {
                        healths[i] = 0;
                        healths[top] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) res.add(healths[i]);
        }
        return res;
    }
}