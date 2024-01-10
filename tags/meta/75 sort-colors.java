/*
https://leetcode.com/problems/sort-colors/

有点像3way快排
维护两个ptr，分别置于队首与队尾
顺序扫描，如果遇到0，和队首ptr交换位置
如果遇到2，和队尾ptr交换位置
注意只有在处理队首交换的时候才move主idx，其他情况只是交换和move对应的队首队尾ptr

Time: O(n)
Space: O(1)
*/

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length, idx0 = 0, idx2 = n - 1, i = 0;
        while (i <= idx2) {
            if (nums[i] == 0) {
                swap(nums, i, idx0);
                i++;
                idx0++;
            } else if (nums[i] == 2) {
                swap(nums, i, idx2);
                idx2--;
            } else i++;
        }
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}