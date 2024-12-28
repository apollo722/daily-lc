/*
https://leetcode.com/problems/minimum-number-of-coins-to-be-added/

假设当前所有硬币能组成到curMax，即1~curMax都可以被数组内coins组成
那下一个要检查的是下一个硬币能不能组成curMax+1以内的数
如果下一枚硬币过大，就需要在结果中加入一枚值为curMax+1的硬币，而加完之后，能组成的最大值便成为了curMax + curMax + 1
如果下一枚硬币能为组成curMax+1以内的值做贡献，那么当前能组成的值即变为curMax+coin
理由是我们直到当前1~curMax都可以被目前为止的硬币组成，多一枚coin，即可以组成所有1~curMax+coin的值
但如果它太大，大过curMax+1，那么这会导致中间出现gap，无法组成curMax+1~coin之间的数字，比如1，4，只能组成1，4，5，中间的2，3无法组成
所以需要先对硬币排序，逐个查询每一枚硬币最远组成到哪里，如果能超过大于或等于target即为终止

例子1：
coins = [1,4,10], target = 19
curMax一开始为0，先要看能不能组成1
第一枚硬币可以组成1，curMax更新为0+1=1
下一枚硬币看能不能组成2及以内的数，4比2大，我们需要一枚值为2的硬币，所以res++，有了2之后，最大能组成的即为2*1+1=3
还是这枚硬币看能不能组成4及以内的数，刚好可以组成四，现在最大值变为了4+3=7
下一枚是10，比要组成的8大，所以我们需要一枚8，此时最大需要2*7+1=15
还是这枚10，最大能组成15+10=25，已经比target大了，即满足条件
所以最后只需要增加2，8这两枚硬币

例子2：
coins = [1,1,1], target = 20
curMax一开始为0，先要看能不能组成1
第一枚硬币可以组成1，curMax更新为0+1=1
下一枚硬币看能不能组成2及以内，新的1刚好可以帮助组成2，所以curMax更新为2
下一枚硬币看能不能组成3及以内，新的1刚好可以帮助组成3，所以curMax更新为3
下一枚硬币看能不能组成4及以内，已经没有新的硬币了，所以直接补一枚4，这时curMax就可以组成到2*3+1=7
接下来都是没有新硬币的情况，需要一枚8，和一枚16
当有了16的时候，最远能够组成31，已经超过了target的20
所以最后只需要增加4，8，16这三枚硬币

Time: O(nlogn + log(target))
Space: O(1)
*/

class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int curMax = 0, res = 0, idx = 0, n = coins.length;
        while (curMax < target) {
            if (idx < n && coins[idx] <= curMax + 1) {
                curMax += coins[idx];
                idx++;
            } else {
                curMax += curMax + 1;
                res++;
            }
        }
        return res;
    }
}