/*
https://leetcode.com/problems/arithmetic-subarrays/

可以将每个query区间进行排序之后逐个查看diff是否恒定
Time: O(mnlogn)，最worst情况，m个query都是n这么长
Space: O(n)

可以用O(n)的方式来验证是不是等差数列
扫描数段找到最大和最小值
两者的差/(n - 1)就是diff
如果diff不是整数直接返回false，因为正整数组diff必为整数
之后只要从最小的数开始，每次cur += diff，每个数都必然会出现以形成等差数列
所以只要看是不是这中间的每个数都出现了即可

运行速度更快的写法可以不用set
如果算出diff等于0，直接返回，证明max和min都是一个数
数段中的每一个数num，减去min之后，对diff的余数，都应该是0
如果余数不是零，那么必然存在不属于数列中的数，返回false
且num/diff的商只能出现一次，因为如果出现两次，证明他们是同一个数
而同一个数的情况已经在diff等于0时候判断过了，所以这里返回false

Time: O(mn)
Space: O(n)
*/

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            res.add(check(nums, l[i], r[i]));
        }
        return res;
    }

    private boolean check(int[] nums, int l, int r) {
        if (l == r || r - l + 1 <= 2) return true;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int i = l; i <= r; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            set.add(nums[i]);
        }
        int n = r - l + 1;
        if ((max - min) % (n - 1) != 0) return false;
        int diff = (max - min) / (n - 1);
        int cur = min + diff;
        
        while (cur < max) {
            if (!set.contains(cur)) return false;
            cur += diff;
        }
        return true;
    }

    /* 运算更快的写法
    private boolean check(int[] nums, int l, int r) {
        if (l == r || r - l + 1 <= 2) return true;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int n = r - l + 1;
        boolean[] visited = new boolean[n];
        if ((max - min) % (n - 1) != 0) return false;
        int diff = (max - min) / (n - 1);
        if (diff == 0) return true;
        for (int i = l; i <= r; i++) {
            int posValue = nums[i] - min;
            if (posValue % diff != 0) return false;
            int pos = posValue / diff;
            if (visited[pos]) return false;
            visited[pos] = true;
        }
        return true;
    }
    */
}