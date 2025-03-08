class Solution {
    // /*
    int[][] memo;
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] arr = new int[n];
        for (int i = 1; i < n - 1; i++) {
            arr[i] = nums[i - 1];
        }
        arr[0] = 1;
        arr[n - 1] = 1;
        memo = new int[n][n];
        return calc(arr, 1, n - 2);
    }

    private int calc(int[] nums, int left, int right) {
        if (left > right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int res = 0;
        for (int k = left; k <= right; k++) {
            int cur = nums[k] * nums[left - 1] * nums[right + 1];
            int total = cur + calc(nums, left, k - 1) + calc(nums, k + 1, right);
            res = Math.max(res, total);
        }
        memo[left][right] = res;
        return res;
    }
    // */
    
    
}


/*
每次射爆一个气球的结果取决于前一次的选择，最终的结果是一系列选择的加和。
选哪个呢？没有什么好的策略能知道选哪个，所以应该要都选一遍看看哪个更大。
假设在某一轮选了第k个，那么它此刻对结果的贡献是nums[k]*nums[?]*nums[?]，两个？是因为目前不确定前面的边界有没有射爆，所以不知道该取哪个值。
如果反着想呢？假设这个第k个是最后被射爆的，那么射爆它的前一轮nums[k]一定存在，这样至少这个边界就确定了。
它的前一轮是[0,k-1]与[k+1,n-1]这两段。状态被转移了，结果可以被前一轮的状态和后一轮的状态累加了！
所以一个top down的写法就是每次在[left,right]段里找一个k，这个k当前这一轮没有被射爆。
那么射它左边和右边的分段的时候，它是可以被取值的。由此来递归下去就逐个的解决了。
本质上相当于反着把问题变成了每轮加一个气球，直到加回原来的长度。top down标配带上memo节省时间。

最后看看bottom up怎么写。
dp[left][right]取决于dp[left][k-1]与dp[k+1][right]。所以必须要保证这两个值先被计算。
对于二维数组，left是row，right是column，且right一定大于等与left，所以这是个上三角阵。
dp[left][k-1]即row不变，col变小，即dp[left][right]同行的左侧。同理dp[k+1][right]是同列的下侧。
也就是如果从最后一行开始遍历，之后每一行从左到右扫描，这样算到dp[left][right]的时候，他依赖的所以值就一定都算出来了。
所以外层循环是行的从下到上，行是left，即n-2到1（这里的n是原长度+2，即补全了原输入的首尾的“假”气球为1）。
内层循环是列的从左到右，列是right，即1到n-2。但是left不能超过right，所以是1到right。
最后在left和right内寻找k。
*/