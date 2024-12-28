/*
https://leetcode.com/problems/the-number-of-beautiful-subsets/

如果排序之后，从小到大依次把元素放与不放到潜在的subset中，并累加到结果中，即标准backtracking的问题
这里用map而不是set，是因为backtracking移除元素的时候，会把所有相同的元素都移除，导致错误

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return backtrack(nums, 0, new HashMap<Integer, Integer>(), k) - 1;
    }

    private int backtrack(int[] nums, int idx, HashMap<Integer, Integer> m, int k) {
        if (nums.length == idx) return 1;
        int res = 0, cur = nums[idx];
        if (m.getOrDefault(cur - k, 0) == 0) {
            m.put(cur, m.getOrDefault(cur, 0) + 1);
            res += backtrack(nums, idx + 1, m, k);
            m.put(cur, m.get(cur) - 1);
        }
        res += backtrack(nums, idx + 1, m, k);
        return res;
    }
}

Time: O(2^n)
Space: O(n)

也可以不排序，只检查一个方向，即只检查+k的方向
先统计所有元素出现的频率，这样相当于把相同元素分组了
之后逐个检查每个元素
对于元素cur，如果map中有cur-k，那就先不算它，而是留到扫描至cur-k时再查
当可以查cur时，记录两个变量，prev和prevPrev
题目只是要求不能有差为k的元素对，但是可以隔一个k组成set，以[2,4,6,8]为例，[2,4]不可以，但是[2,6]可以
所以每次要把前前的subset个数存起来，具体逻辑如下，以[2,2,4,6,8]为例
统计好的map={2:2, 4:1, 6:1, 8:1}，由于我们都是从可能的等差数列的头部开始真正计算，所以一定是从2开始
预设res=1，即空集()

第一个元素2，有两个，那么就是总共有2^n=2^2=4种组合，也包括空集，即(),(2),(2),(2,2)，注：这道题subset是允许重复的，两个(2)算两个subset
那么去掉空集，也就是有3个子集
因为是第一轮，所以prev=0，prevPrev也是0，因为隔代加进结果，res+=prevPrev仍为1（空集()）

之后cur+=k，即4，仍然存在，那么考虑4的情况
这时候前一代prevPrev即为3，前代为2^1-1=1，即(4)，但是这个(4)可以和前前代时的结果res的每一个集合组成valid集合，因为是前前代隔2k
所以就是1*1=1，组合完了还是1，即相当于把(4)加到了前前代结果的()中，仍是(4)
这时前前代已经可以加入结果了，因为下一个要检查6了，而前前代是2，对于6来说，2时代的集合都是可以和它（6）组和的，所res+=3，即4
此时res相当于是(),(2),(2),(2,2)

接下来检查6，前代4变成前前代，prevPrev=1，之后6有一个非空集合(6)，可以和前前代的4个结果分别形成新的集合
相当于(6),(2,6),(2,6),(2,2,6)，所以prev=4
之后前前代的集合已经可以加入结果了，因为下一轮要检查8了，4时代已经可以被考虑了，res+=1，变为5，即(),(2),(2),(2,2),(4)

接下来考虑8，前代6变成前前代，prevPrev=4，之后8，有一个非空集合(8)，可以和前前代的5个结果分别形成新的集合
相当于(8),(2,8),(2,8),(2,2,8),(4,8)，所以prev=5
之后前前代的集合已经可以加入结果了，即res+=4，变为9，即(),(2),(2),(2,2),(4),(6),(2,6),(2,6),(2,2,6)

这一序列的等差数列已经没有元素了，那么前一代的8时代的集合也可以加进来了，在循环之外的res+=prev，即9+5=14
即(),(2),(2),(2,2),(4),(6),(2,6),(2,6),(2,2,6),(8),(2,8),(2,8),(2,2,8),(4,8)

最后只要减掉空集1，即为答案

Time: O(n)
Space: O(n)
*/

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) m.put(num, m.getOrDefault(num, 0) + 1);
        int res = 1, prev = 0, prevPrev = 0;
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int cur = e.getKey();
            if (m.containsKey(cur - k)) continue;
            prev = 0;
            while (m.containsKey(cur)) {
                prevPrev = prev;
                prev = ((1 << m.get(cur)) - 1) * res;
                res += prevPrev;
                cur += k;
            }
            res += prev;
        }
        return res - 1;
    }
}