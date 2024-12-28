/*
https://leetcode.com/problems/odd-even-jump/

可以从尾部开始想
最后一个元素一定是满足条件的，那么另一个元素可以通过odd或者even步来跳到最后一个元素
这样就形成了dp转移：每一个元素都可以被之前的某一个元素由odd或者even来跳到
所以从后往前扫描，后面的结果已经求出，前面的结果可以依赖于后面求出的结果

扫描到某一位置时，要能快速的知道后面的哪个元素可以让它odd或者even步跳到
所以可以通过排序后面的数组快速找到对应的ceilling或者floor的index
即利用TreeMap做到

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[] dpOdd = new boolean[n], dpEven = new boolean[n];
        dpOdd[n - 1] = true;
        dpEven[n - 1] = true;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        m.put(arr[n - 1], n - 1);
        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            int curNum = arr[i];
            Integer largerKey = m.ceilingKey(curNum);
            if (largerKey != null) {
                dpOdd[i] = dpEven[m.get(largerKey)];
            }
            Integer smallerKey = m.floorKey(curNum);
            if (smallerKey != null) {
                dpEven[i] = dpOdd[m.get(smallerKey)];
            }
            if (dpOdd[i]) res++;
            m.put(curNum, i);
        }
        return res;
    }
}