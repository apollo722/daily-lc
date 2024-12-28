/*
https://leetcode.com/problems/image-smoother/

没有什么多余的想法，就是对于每个格子扫描周围一圈来计算结果
唯一可以优化的是空间复杂度
如果直接把结果存到输入中的话，会影响后续计算，所以要想办法encode结果到原输入
这里的做法是用bitmask
因为题目给定每个数字不超过255，即只有最后的8位存了数字
所以可以将计算后的结果存到9-16位上，计算完成后再移动回来即可
计算时，只取原输入，即数字的后8位即可

Time: O(mn)
Space: O(1)
*/

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0, cnt = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            sum += img[x][y] & 255;
                            cnt++;
                        }
                    }
                }
                img[i][j] |= (sum / cnt) << 8;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] >>= 8;
            }
        }
        return img;
    }
}