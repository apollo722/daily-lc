/*
https://leetcode.com/problems/put-boxes-into-the-warehouse-ii/

排序后贪心，从最大的开始放
用两个ptr分别从两侧开始放箱子
如果任何一边可以放置当前的箱子，即可推入，否则继续看更小一点的

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int l = 0, r = warehouse.length - 1, res = 0, i = boxes.length - 1;
        while (l <= r && i >= 0) {
            if (boxes[i] <= warehouse[l]) {
                res++;
                l++;
            } else if (boxes[i] <= warehouse[r]) {
                r--;
                res++;
            } 
            i--;
        }
        return res;
    }
}