/*
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

KPM模板
字符串匹配通用模板，属于需要记住的范畴

Time: O(n)
Space: O(m)
*/

class Solution {
    class KMP {
        String target;
        int[] next;

        KMP (String t) {
            this.target = t;
            next = new int[t.length()];
            buildNext();
        }

        public int search(String source) {
            int m = source.length(), n = target.length();
            int pos = 0, tarIdx = 0;
            while (tarIdx < m) {
                if (source.charAt(tarIdx) == target.charAt(pos)) {
                    tarIdx++;
                    pos++;
                } else if (pos != 0) {
                    pos = next[pos - 1];
                } else {
                    tarIdx++;
                }
                if (n == pos) {
                    // pos = next[pos - 1];
                    return tarIdx - pos;
                }
            }
            return -1;
        }

        private void buildNext() {
            int cur = 0, pos = 1;
            next[0] = 0;
            while (pos < target.length()) {
                if (target.charAt(cur) == target.charAt(pos)) {
                    next[pos++] = ++cur;
                } else if (cur != 0) {
                    cur = next[cur - 1];
                } else {
                    next[pos++] = cur;
                }
            }
        }
    }
    public int strStr(String haystack, String needle) {
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }
}