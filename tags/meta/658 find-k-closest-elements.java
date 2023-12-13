/*
https://leetcode.com/problems/find-k-closest-elements/

二分查找，找起点位置
每次比较找到的起点，和起点+k的位置，也就是potential的下一位
如果potential的下一位对x的差小于起始位置，证明起始数太小了，l右移
如果potential的下一位对x的差大于或等于起始位置，证明当前位置可能是最终的位置，那继续往左查看有没有更小的
如果找到的位置右侧不足k + 1个（即恰好第k个落在边界左侧），那当前位置可能是最终起点，要继续左查

Time: O(logn + k)
Space: O(1)
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, l = 0, r = n - k, start = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid + k < n) {
                if (x - arr[mid] > arr[mid + k] - x) {
                    l = mid + 1;
                } else {
                    start = mid;
                    r = mid - 1;
                }
            } else {
                start = mid;
                r = mid - 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(arr[start++]);
        }
        return res;
    }
}