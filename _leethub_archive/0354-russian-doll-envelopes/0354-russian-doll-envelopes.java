class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) secondDim[i] = envelopes[i][1];
        return getLIS(secondDim);
    }

    private int getLIS(int[] arr) {
        List<Integer> increaseList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (increaseList.size() == 0 || increaseList.get(increaseList.size() - 1) < cur) {
                increaseList.add(cur);
            } else {
                int idx = findFirstLarge(increaseList, cur);
                if (idx != -1) increaseList.set(idx, cur);
            }
        }
        return increaseList.size();
    }

    private int findFirstLarge(List<Integer> arr, int tar) {
        int l = 0, r = arr.size() - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cur = arr.get(mid);
            if (cur < tar) l = mid + 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }
}


/*
先不要想信封这种2D的问题。如果只有1维，问题就变成了找一个最长的递增序列的长度。
那么问题就转化成了300. Longest Increasing Subsequence。
如果信封的两个维度都是完美的递增，那么按照一个维度排序，之后按照LIS的找法找到最长即可。
但两个维度不一定保证按其中一个维度递增后另一个也是递增。
所以当对一个维度排序之后，另一个维度的处理就是要关注的问题。
举一个例子：[[1, 3], [1, 4], [1, 5], [2, 3]]。
这里已经按照第一维排序了，第二维现在是3，4，5，3。按照题意，同样的长宽不能装下，必须要严格大于。
所以[1,3]，[1,4]不能互相囊括。
如果按照第二个维度降序，这个问题就解决了：[[1, 5], [1, 4], [1, 3], [2, 3]]。
这样做的解释是，按照LIS的解法，要找最长的递增序列，要保证序列里每个位置都尽可能小（因为这样才有可能容纳更多数字）。
如果第二维也是增序或者乱序，那么找递增序列的时候就会碰到第一维相等而不满足题意的情况。
所以在第一维相等的时候，按照第二维降序排列会保证最大的那个会在构建增序序列的时候被过后更小的数字替换掉。
因为第一个维度已经保证了是递增，所以这样替换之后两个维度一定都是满足题意的。
*/