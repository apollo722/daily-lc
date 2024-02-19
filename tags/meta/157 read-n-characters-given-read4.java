/*
https://leetcode.com/problems/read-n-characters-given-read4/

用临时buffer来存储每次读取的字符，直到长度达到n或者read4读不出来新字符

Time: O(n)
Space: O(1)
*/

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int idx = 0;
        while (true) {
            char[] tmp = new char[4];
            int cur = read4(tmp);
            if (cur == 0) return idx;
            for (int i = 0; i < cur && idx < n; i++) {
                buf[idx++] = tmp[i];
            }
        }
    }
}