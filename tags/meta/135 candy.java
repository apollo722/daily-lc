/*
https://leetcode.com/problems/candy/

two pass贪心可以做，即先从左到右扫一遍，rating比前一个大且candy不如前一个多的，就把candy置为前一个+1
之后再反着扫一遍如法炮制

one pass constant space可以用爬山的思想
整个rating分布只会有上升段，下降段，和平段三种情况
上升段的最优分配即1，2，...，n，下降段也一样，平段如果两边不是上升或下降段的话可以都置为1
从左到右扫描，track相邻之间元素的关系，如果是上升段，那么up++，并记录peak
每走一步res都要+=up+1，即上升段的位置+1
如果在平段了，那么所有的都可以置0重新计算，res也只需要+1即可
如果到了下降段，相当于反向的从下降段开始逐1递增
但是如果peak大于当前下降段的长度，可以从res中减掉1
比如，[1,2,3,4,2,1]
到4的时候peak为4，到2的时候down为1，res+=down+1，到1的时候res+=down+1，down此时是2
即在下降段，res分别加了2，与3，但实际上可以加1与2，这是因为下降段更短
所以在下降段更短的时候，要把多余的糖从结果中减去
所以down小于peak的时候res都可以少1

Time: O(n)
Space: O(1)
*/

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n <= 1) return n;
        int res = 1, up = 0, down = 0, peak = 0;
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                up++;
                down = 0;
                peak = up;
                res += up + 1;
            } else if (ratings[i] == ratings[i + 1]) {
                up = 0;
                down = 0;
                peak = 0;
                res += 1;
            } else {
                up = 0;
                down++;
                res += down + 1;
                if (peak >= down) res--;
            }
        }
        return res;
    }
}