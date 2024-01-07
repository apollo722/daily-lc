/*
https://leetcode.com/problems/h-index-ii/

在i处的citation number为c的话，那么此时有n-i个paper（包括i）的citation是大于等于c的
如果c>=n-i，根据定义，n-i个paper的citation是大于等于c的，也即是大于等于n-i的，那么n-i即为答案
那么要找到第一个满足条件的位置，因为如果再往后，i越来越大，n-i会越来越小，我们要找最大的数作为h index
所以在有序数组中，要找的是c==n-i的数，如果存在的话，直接返回
否则如果不存在，证明没有一个位置的citation恰好等于n-i，那么更靠后的那个位置可以满足h index定义
最后退出循环的位置是r, l，那么靠后的位置是l，所以返回n-l

举两个例子
[0]，退出循环时r=0，l=1，因为循环内citations[mid=0]<1-0 -> l=1了
[100]，退出循环时r=-1，l=0，因为循环内citations[mid=0]>1-0 -> r=-1了


Time: O(logn)
Space: O(1)
*/

class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length - 1, res = 0, n = citations.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] == n - mid) return citations[mid];
            else if (citations[mid] < n - mid) l = mid + 1;
            else {
                r = mid - 1;
            }
        }
        return n - l;
    }
}