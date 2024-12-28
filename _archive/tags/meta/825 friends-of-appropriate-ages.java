/*
https://leetcode.com/problems/friends-of-appropriate-ages/

题目里的age是有上下限的，所以可以直接桶排序统计出所有年龄的分布count
之后统计年龄的preSum，这样可以快速的求出任意年龄区间中有多少人
15岁以下是不可能加任何人好友的，所以从15岁开始
先找到上限，他自己，和下限，i/2 + 7这个区间中有多少人
最后去掉自己，计算出来即为结果

Time: O(n)
Space: O(1)
*/

class Solution {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] ageCount = new int[121], preSum = new int[121];
        for(int age : ages) 
            ageCount[age]++;
        
        for(int i = 1; i <= 120; i++) 
            preSum[i] = ageCount[i] + preSum[i - 1];
        
        for(int i = 15; i <= 120; i++) {
            if (ageCount[i] == 0) continue;
            int count = preSum[i] - preSum[i / 2 + 7];
            res += ageCount[i] * (count - 1);
        }
        return res;
    }
}