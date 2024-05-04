/*
https://leetcode.com/problems/boats-to-save-people/

排序后贪心，因为最大的元素不超过limit，且最多只能两人一组
那么每次找人，最大的一定需要一艘船，再看能不能顺道配个小的
能就把小的放船上，不能就继续

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0, r = people.length - 1, res = 0;
        Arrays.sort(people);
        while (l <= r) {
            if (people[l] + people[r] <= limit) l++;
            r--;
            res++;
        }
        return res;
    }
}