class Solution {
    public int oddEvenJumps(int[] arr) {
        int res = 1, n = arr.length;
        boolean[] odd = new boolean[n], even = new boolean[n];
        TreeMap<Integer, Integer> m = new TreeMap<>();
        odd[n - 1] = true;
        even[n - 1] = true;
        m.put(arr[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int cur = arr[i];
            Integer firstLarge = m.ceilingKey(cur);
            if (firstLarge != null) {
                odd[i] = even[m.get(firstLarge)];
            }
            Integer firstSmall = m.floorKey(cur);
            if (firstSmall != null) {
                even[i] = odd[m.get(firstSmall)];
            }
            if (odd[i]) res++;
            m.put(cur, i);
        }
        return res;
    }
}


/*
从后往前想，最后一个位置本身肯定是符合条件的。
倒数第二个位置如果想符合条件，那么它的奇数偶数跳的位置肯定也必须要符合条件才可以。
这就是一个状态转移方程啊。
用两个数组分别存储每个位置下一跳是奇数或者偶数跳是否能跳到最后。
那么一个位置找到下一个符合跳跃规则的index之后，只要看它能不能跳到最后即可。
如何快速找到符合条约规则的index呢？对于奇数跳，就找离它最近的刚好大于它的位置，偶数跳同理。
如果后面的元素都是有序的，那就能一下子找到了。但光有序还不够，还得找最近的。
这里用到treemap。它天然有序，而且如果倒着扫，后入map的肯定就是离着最近的。
最后按照状态转移往前扫描每个位置。当那个位置的奇数跳（因为第一跳一定是奇数）为真的时候，res++。
*/