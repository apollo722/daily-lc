/*
https://leetcode.com/problems/moving-stones-until-consecutive/

a，b，c排序后，只有以下几种情况
如果a，b，c中间没有空隙，那么min只可能是0
如果a，b，c之中有任何一个位置没有空隙，或者任何一个位置有1个空隙，那么min为1
其他情况min都是2
min只可能是0，1，2
max就是a，b，c之间的空隙和了

Time: O(1)
Space: O(1)
*/

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        int min = 0;
        if (arr[1] - 1 == arr[0] && arr[1] + 1 == arr[2]) min = 0;
        else if (arr[1] - 2 == arr[0] || arr[1] + 2 == arr[2] || arr[1] - 1 == arr[0] || arr[2] - 1 == arr[1]) min = 1;
        else min = 2;
        int max = arr[2] - arr[1] - 1 + arr[1] - arr[0] - 1;
        return new int[]{min, max};
    }
}