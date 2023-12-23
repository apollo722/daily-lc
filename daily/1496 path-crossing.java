/*
https://leetcode.com/problems/path-crossing/

并没有特别的算法，直接把每个位置的坐标存到set中即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> s = new HashSet<>();
        s.add(get(x, y));
        for (char c : path.toCharArray()) {
            if (c == 'S') y--;
            else if (c == 'N') y++;
            else if (c == 'W') x--;
            else x++;
            String str = get(x, y);
            if (s.contains(str)) return true;
            s.add(str);
        }
        return false;
    }

    private String get(int x, int y) {
        StringBuilder str = new StringBuilder();
        str.append(x);
        str.append(",");
        str.append(y);
        return str.toString();
    }
}