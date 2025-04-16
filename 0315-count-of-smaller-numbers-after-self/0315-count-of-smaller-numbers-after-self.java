/*
经典的分治算法。题目中有很多可以应用在其他题的思路。
朴素的想，如何找到任意一个元素右侧比它更小的元素个数？一遍遍循环找全为止。
如何能加速找的过程呢？目的是为了找比目标元素更小的元素个数。
如果是在排好序的数组部分里找，那么找到比目标小元素的个数就很方便了。
所以如果假设某一个阶段，数组分成两部分，两侧都是有序的，那么左侧的每一个元素就可以用二分查找在右侧找到比它小的元素的个数，之后更新到最后的结果中。
如果是递归的保证每一个阶段都是有序的，那么就可以用这个思路把整个数组的结果求解。
所以这就是个分治算法，从最小的数组部分开始，两两合并，如同merge sort。

在merge的过程中，其实就可以把任何元素右侧比它小的个数统计出来。
在左右merge的过程中，当左侧元素小于等于右侧元素的时候，左侧元素要被放入merge的结果。
在这个时刻，右侧已经被放入merge结果的元素就是比当前左侧元素小的元素。
有多少个呢？j-(mid+1)个，即当前右半边ptr与右半边起点的距离。
一个细节的部分是等号的位置。即左侧元素小于等于右侧元素的时候，要进行右侧元素个数的统计。
这是因为当放的符号是小于等于的时候，即将要把左侧元素放进去了，这个时候统计右侧元素才能找到严格小于它的。
举例子：
左侧是[3]，右侧是[2,3,4]
如果3<3，放右侧元素的话，那么在下一步，3<4的时候，会把右侧部分的2和3都统计为小于3的元素，明显是错误的。
所以要把等号放到处理左侧元素的branch，才能保证正确。

最后就是因为要保证原数组的位置不变，所以整个排序的操作是作用在index数组上的。
相当于原数组没有改变，只是在根据原数组的值来排序index。

Time: O(NlogN)
Space: O(N)
*/

class Solution {
    int[] resArr;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        resArr = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        solve(nums, indices, 0, n - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(resArr[i]);
        }
        return res;
    }

    private void solve(int[] nums, int[] indices, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        solve(nums, indices, l, mid);
        solve(nums, indices, mid + 1, r);
        int i = l, j = mid + 1, p = 0;
        int[] tmp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                resArr[indices[i]] += j - (mid + 1);
                tmp[p++] = indices[i];
                i++;
            } else {
                tmp[p++] = indices[j];
                j++;
            }
        }
        while (i <= mid) {
            resArr[indices[i]] += j - (mid + 1);
            tmp[p++] = indices[i];
            i++;
        }
        while (j <= r) {
            tmp[p++] = indices[j];
            j++;
        }
        for (int k = l; k <= r; k++) {
            indices[k] = tmp[k - l];
        }
    }
}