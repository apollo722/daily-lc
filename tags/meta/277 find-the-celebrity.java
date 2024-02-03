/*
https://leetcode.com/problems/find-the-celebrity/

如果i认识j，那么i一定不是名人，而j可能是名人
所以先扫描所有人，找到一个备选，如果备选谁都不认识，那么他可能是名人
如果在扫描中，他有认识的人，那么他认识的那个人，可以成为下一个备选
中间跳过的人一律都不会成为备选，是因为名人一定要被所有人认识，而备选不认识他们，证明他们一定不是名人
最后剩下来的备选，有可能是名人，也有可能不是，所以额外检查一下
即再扫描一边除他自己的所有人，如果他认识任何一个人，或者有任何人不认识他，那他就不是名人

Time: O(n)
Space: O(1)
*/

public class Solution extends Relation {
    int n;
    public int findCelebrity(int n) {
        this.n = n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (knows(res, i)) res = i;
        }
        if (isCelebrity(res)) return res;
        return -1;
    }

    private boolean isCelebrity(int tar) {
        for (int i = 0; i < n; i++) {
            if (tar == i) continue;
            if (knows(tar, i) || !knows(i, tar)) return false;
        }
        return true;
    }
}