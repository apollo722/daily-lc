/*
https://leetcode.com/problems/find-in-mountain-array/

首先先要找到top点在哪里，这样可以二分查找分别找左右段
要想找到top点，就要看任何一个位置和它左边的数的大小关系
如果mid左边大于mid，则它们处于下降段，top一定在mid左边
反之则在上升段，top可能是r，也可能再右边
这里为什么是r呢？因为要保证每次都能找到mid和它的左边，所以边界条件是l+1<r
对比一下各种二分查找的边界条件
如果是l<=r，循环中会check到l=r处的位置，最后一定是l在r的右侧
如果是l<r，循环中不会check到l=r处的位置，最后l可以在r的右侧，也可以重合，循环中mid最后有可能等于l
如果是l+1<r，循环中l，mid，r任何时刻都是并列的，即不会有mid-1越界的情况，跳出循环之前，如果l，mid，r紧挨着
那么如果最后需要查右段，即l=mid，那么r是top，查左段，r=mid-1，r依然是top
如果跳出循环前，l，mid，r并不挨着，即l+2=r，例如l=0，r=3，此时mid为1，mid-1为0
如果走右段，l=1后，还可以再check一次，如果走左段，r=mid-1=l，即top为l=r
所以最后的结尾r一定是top

找到top点后，接下来只要先查左后查有段即可，因为可能左右段都有target，所以要先查左边
而右段的二分查找要反过来，因为右侧是递减段

Time: O(logn)
Space: O(1)
*/

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0, r = n - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int midVal = mountainArr.get(mid), left = mountainArr.get(mid - 1);
            if (left > midVal) r = mid - 1;
            else l = mid;
        }
        int top = r;
        l = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) return mid;
            else if (midVal < target) l = mid + 1;
            else r = mid - 1;
        }
        l = top;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) return mid;
            else if (midVal > target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}