/*
https://leetcode.com/problems/string-transformation/

https://www.youtube.com/watch?v=l2hNd3BlHkc

t可以在两个s拼接成ss（即s+s）中找到
即将s的某个prefix添加到s的尾部组成t

一个长度为n的s总共有n个位置（0 ~ n-1）可供选择作为prefix，通过从prefix处rotate s并拼接，即可组成新的s'

总共有k步，每一步都有n个状态
每个状态都有两种情况
f：bad rotation，意为这样rotate过后的s'并不是t
g：good rotation，意为这样rotate过后的s'是t

也就是每一种状态只有f和g两种情况
每一步f和g都可以由前一步的f和g组成

假设在ss中，总共有p种情况可以构成t
其中有四种情况
f -> f：共n - 1 - p种转化，总共n种可能的rotate，p种可以构成g，即n - p构成f，抛开现在f自己的1
f -> g：共p种转化
g -> f：共n - p种转化
g -> g：共p - 1种转化

所以
f' = f->f + g->f
g' = f->g + g->g

用矩阵表示即为

|f'|   |n-1-p, n-p|   |f|
|g'| = |  p  , p-1| x |g|


即右侧的矩阵需要从初始状态乘k次达到最终状态
初始状态即f或g，取决于s一开始是否等于t
最终状态即t，也就是g，一个good rotation

利用矩阵相乘求解矩阵T的k次幂
2x2的矩阵可以用一维矩阵表示
{a, b, c, d} -> |a, b|
                |c, d|

如果初始是f（s!=t），即{1, 0}，那么最终的g状态就是T[2]（T[2] * 1 + T[3] * 0）
如果初始是g（s==t），即{0, 1}，那么最终的g状态就是T[3]（T[2] * 0 + T[3] * 1）

Time: O(m + n + log k)，其中KMP search需要O(m + n)，矩阵相乘需要O(logk)
Space: O(n + log k)，其中KMP需要O(n)来build next数组，矩阵相乘recursion需要O(logk)

求解p的时候，用到了KMP算法
并且组成ss的时候，去掉了最后一个位置
这是因为如果s==t的话，寻找p的时候i=0和i=n时都会满足，但这两个是同一种情况
所以去掉最后一个位置以去重
*/

class Solution {
    long mod = (long)(1e9 + 7);
    public int numberOfWays(String s, String t, long k) {
        String source = s + s.substring(0, s.length() - 1);
        KMP kmp = new KMP(t);
        int p = kmp.search(source);
        int n = s.length();
        long[] T = new long[]{n - p - 1, n - p, p, p - 1};
        long[] Tk = quickMul(T, k);
        if (s.equals(t)) return (int)Tk[3];
        else return (int)Tk[2];
    }

    private long[] quickMul(long[] mat, long n) {
        if (n == 0) return new long[]{1, 0, 0, 1};  // mat的0次幂为单位矩阵
        long[] mat2 = quickMul(mat, n / 2);
        if (n % 2 == 0) return multiply(mat2, mat2);
        else return multiply(multiply(mat2, mat2), mat);
    }

    private long[] multiply(long[] mat1, long[] mat2) {
        long a1 = mat1[0], b1 = mat1[1], c1 = mat1[2], d1 = mat1[3];
        long a2 = mat2[0], b2 = mat2[1], c2 = mat2[2], d2 = mat2[3];
        return new long[]{(a1 * a2 + b1 * c2) % mod, (a1 * b2 + b1 * d2) % mod, (c1 * a2 + d1 * c2) % mod, (c1 * b2 + d1 * d2) % mod};
    }

    class KMP {
        int[] next;
        String tar;
        int n;
        public KMP(String tar) {
            this.n = tar.length();
            this.tar = tar;
            this.next = new int[n];
            this.buildNext();
        }

        public int search(String s) {
            int res = 0;
            int i = 0, j = 0;
            while (j < s.length()) {
                if (tar.charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                } else if (i > 0) {
                    i = this.next[i - 1];
                } else {
                    j++;
                }
                if (i == n) {
                    res++;
                    i = next[i - 1];
                }
            }
            return res;
        }

        // next数组是到i位置的substring拥有相同前后缀的长度
        private void buildNext() {
            next[0] = 0;
            int i = 1, cur = 0;
            while (i < n) {
                if (tar.charAt(i) == tar.charAt(cur)) {
                    ++cur;
                    next[i++] = cur;
                } else if (cur > 0) {
                    cur = next[cur - 1];
                } else {
                    next[i++] = cur;
                }
            }
        }
    }
}