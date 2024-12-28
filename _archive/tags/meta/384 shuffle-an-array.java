/*
https://leetcode.com/problems/shuffle-an-array/

模板随机算法，每次把一个idx替换成随机的另一个idx即可

Time: O(n)
Space: O(n)
*/

class Solution {
    int[] arr;
    int[] nums;
    Random rand = new Random();
    public Solution(int[] nums) {
        int n = nums.length;
        this.arr = new int[n];
        this.nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = nums[i];
            this.arr[i] = nums[i];
        }
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < arr.length; i++) {
            swap(i, rand.nextInt(arr.length));
        }
        return arr;
    }

    private void swap(int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}