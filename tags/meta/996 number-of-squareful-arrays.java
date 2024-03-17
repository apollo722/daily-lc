/*
https://leetcode.com/problems/number-of-squareful-arrays/

相当于找到所有不重复的permutation看是否满足条件，即47题，之后看每个相邻元素
但这样的话对于本题会不符合memory limit，也就是不能把所有的排列先求出来再判断
因为很多组合可能前几个元素不符合就不用再看了，所以不用求出完整的组合，甚至不用存储组合，只要看是否选择了所有元素就行
所以backtrack的方式来看当前元素和之前元素能否组成完全平方数即可
如何去重加速是这道题比较重要的地方，一般这种问题都要排序之后去重相邻相同元素
先看基本逻辑，如果有前一个项且当前数字和前一个数字不能能组成完全平方数，肯定不用继续下去了
如果当前的数字已经加过了，不用继续下去了（每一轮肯定要加新的数字）

如果当前数字是一个重复数字，看看上一个数字是否已经被加入到考虑当中
如果上一个数字被考虑了，那么就说明本轮处理是新的处理，那么可以继续下去
否则，如果上一个数字没被考虑，证明for some reason上一个数字不符合条件，那么因为当前数字和上一个数字相同，那么这个数字也不用考虑了
也就是i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]的逻辑
目的是为了往前推进，而不是重复考虑同样的数字，同样的数字上理论没被考虑肯定是有原因的（鉴于都是顺序一个个考虑），所以本轮也不用考虑了

Time: O(n! n)
Space: O(n)
*/

class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, visited, 0, -1);
    }

    private int backtrack(int[] nums, boolean[] visited, int idx, int prev) {
        if (idx == nums.length) return 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) || visited[i] || (prev != -1 && !check(prev, nums[i]))) continue;
            visited[i] = true;
            res += backtrack(nums, visited, idx + 1, nums[i]);
            visited[i] = false;
        }
        return res;
    }

    private boolean check(int a, int b) {
        return Math.sqrt(a + b) % 1 == 0;
    }
}