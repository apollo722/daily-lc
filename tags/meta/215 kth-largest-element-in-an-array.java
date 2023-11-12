/*
https://leetcode.com/problems/kth-largest-element-in-an-array/

第k大就是n-k个下标位置
quick-select

Time: O(n)，worst O(n2)如果每次都选不对pivot
Space: O(n)，recursive call复制了原来的数组
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length, tar = n - k;
        int l = 0, r = n - 1;
        while (l <= r) {
            int idx = partition(nums, l, r);
            if (idx == tar) return nums[idx];
            else if (idx < tar) l = idx + 1;
            else r = idx - 1;
        }
        return -1;
    }

    private int partition(int[] arr, int start, int end) {
        if (start >= end) return start;
        Random rand = new Random();
        int pivotIdx = rand.nextInt(end - start + 1) + start;
        swap(arr, start, pivotIdx);
        int p = arr[start];
        int l = start, r = end + 1;
        while (l <= r) {
            while (arr[++l] < p) if (l >= end) break;
            while (arr[--r] > p) if (r <= start) break;
            if (l >= r) break;
            swap(arr, l, r);
        }
        swap(arr, start, r);
        return r;
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}