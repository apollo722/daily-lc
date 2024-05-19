/*
https://leetcode.com/problems/number-of-spaces-cleaning-robot-cleaned/

dfs模板

Time: O(mn)
Space: O(mn)
*/

class Solution {
    int[] dir = {-1, 0, 1, 0, -1};

    public int numberOfCleanRooms(int[][] room) {
        int m = room.length, n = room[0].length;
        HashSet<String> visited = new HashSet<>();
        HashSet<String> cleaned = new HashSet<>();
        dfs(room, m, n, 0, 0, 0, visited, cleaned);
        return cleaned.size();
    }

    private void dfs(int[][] room, int m, int n, int r, int c, int direction, HashSet<String> visited, HashSet<String> cleaned) {
        String currentState = r + "@" + c + "@" + direction;
        if (visited.contains(currentState)) return;
        
        visited.add(currentState);
        cleaned.add(r + "@" + c);
        
        for (int d = 0; d < 4; d++) { // Try all four directions
            int newDirection = (direction + d) % 4;
            int i = r + dir[newDirection];
            int j = c + dir[newDirection + 1];
            if (i >= 0 && i < m && j >= 0 && j < n && room[i][j] == 0) {
                dfs(room, m, n, i, j, newDirection, visited, cleaned);
                break;
            }
        }
    }
}