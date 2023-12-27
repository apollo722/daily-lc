/*
https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

找到所有相同字符段中用时最大的那个作为保留即可，其它都要加到结果中去

下面的写法可以省去求和再减去最大的过程，复杂度一样
即每段只找最大的，非最大的直接加入结果，之后更新段内最大值
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length(), res = 0, i = 0, curMax = 0;
        while (i < n) {
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) curMax = 0;
            res += Math.min(curMax, neededTime[i]);
            curMax = Math.max(curMax, neededTime[i]);
            i++;
        }
        return res;
    }
}

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length(), res = 0, i = 0;
        while (i < n) {
            int j = i + 1, sum = neededTime[i], max = sum;
            char c = colors.charAt(i);
            while (j < n && c == colors.charAt(j)) {
                max = Math.max(max, neededTime[j]);
                sum += neededTime[j];
                j++;
            }
            res += sum - max;
            i = j;
        }
        return res;
    }
}