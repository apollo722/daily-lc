/*
https://leetcode.com/problems/previous-permutation-with-one-swap/

从右向左找第一个递减的数，如果没有（即整个数组递增）则返回原来数组
从找到的数字右侧开始找小于它的最大的数进行交换

从右开始找是为了保证交换后数字最大
找到后要交换右面最大的小于它的数也是为了保证交换后结果最大

Time: O(n)
Space: O(1)
*/

class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) i--;
        if (i == -1) return arr;
        int max = -1, idx = i + 1;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[i] && arr[j] > max) {
                idx = j;
                max = arr[j];
            }
        }
        int t = arr[i];
        arr[i] = arr[idx];
        arr[idx] = t;
        return arr;
    }
}