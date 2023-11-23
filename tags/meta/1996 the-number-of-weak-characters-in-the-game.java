/*
https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/

先按照一个属性排序，比如按照attack排序
当从后往前扫的时候，后面的attack属性一定比前面的大，所以只需要看后面有没有比它另一属性defense更大的值即可
即扫描时，track max defense so far，一旦当前defense比max小，那它一定满足要求
这么做需要在attach一样的时候按照defense逆序
比如 [[1,1],[1,2],[2,1],[2,2]]按照defense升序
那么[2,1]对于[2,2]来说并不满足要求，因为attack值相同
所以这个时候如果降序defense
[[1,2],[1,1],[2,2],[2,1]]
当扫描到[2,2]时，max so far只是1，所以不会存在误判情况，因为在相同attack情况下，任何时候defense都是当前attack中最大的，不会满足条件，满足条件的maxDefense一定来自更大的attack组

Time: O(nlogn)
Space: O(1)，不考虑排序需要的空间O(logn)

另一种做法是利用桶排序的思想，对于每个attack值找到大于它的最大defense值
这样当扫描一对输入时，只需要看数据的defense是否小于数据attack + 1处的defense值即可
所以要先统计最大的attack值是多少
对于每个attack值，找到当前值最大的defense
之后再通过逆序扫描attack值数组，找到大于attack值的最大defense
（注意attack值数组长度需要是max attack + 2，因为每次检查输入对要检查attack + 1的位置）

Time: O(n + k)，k为最大attack值
Space: O(k)
*/

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int n = properties.length, maxDefense = Integer.MIN_VALUE, res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (properties[i][1] < maxDefense) res++;
            maxDefense = Math.max(maxDefense, properties[i][1]);
        }
        return res;
    }

    /*
    public int numberOfWeakCharacters(int[][] properties) {
        int maxAttack = Integer.MIN_VALUE, n = properties.length;
        for (int i = 0; i < n; i++) maxAttack = Math.max(maxAttack, properties[i][0]);
        int[] maxDefense = new int[maxAttack + 2];
        for (int[] p : properties) {
            int a = p[0], d = p[1];
            maxDefense[a] = Math.max(maxDefense[a], d);
        }
        for (int i = maxAttack - 1; i >= 0; i--) maxDefense[i] = Math.max(maxDefense[i + 1], maxDefense[i]);
        int res = 0;
        for (int[] p : properties) {
            int a = p[0], d = p[1];
            if (d < maxDefense[a + 1]) res++;
        }
        return res;
    }
    */
}