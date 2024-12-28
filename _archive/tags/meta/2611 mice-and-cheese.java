/*
https://leetcode.com/problems/mice-and-cheese/

按照reward1-reward2的差来排序，从reward1中选k个reward1-reward2更大的，剩下的选reward2

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length, res = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reward1[i] - reward2[i];
            res += reward2[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res += arr[n - i - 1];
        }
        return res;
    }
}