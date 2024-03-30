/*
https://leetcode.com/problems/most-frequent-ids/

因为频率是动态更新的，所以要想办法快速的找出当前最高的频率
首先一定要有个map来实时更新当前所有id的频率
之后可以用pq来按照频率来存储当前的id频率数对
当有新的操作的时候，只需要保证pq队首频率和map中的频率保持一致即可，因为我们只关心最高频的是不是更新过的
如果最高频id当前频率和map中的相同，那么就保留，否则证明是个过时的数据，就要从队列中去除
之后把当前新更新的id加进去，再取队首即可
同一时刻pq中可能有很多相同id的频率，但不重要，只要队首的频率是更新过的就行

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        HashMap<Long, Long> m = new HashMap<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (int)(b[1] - a[1]));
        long[] res = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            long id = nums[i], cnt = freq[i];
            m.put(id, m.getOrDefault(id, (long)0) + cnt);
            while (!pq.isEmpty()) {
                long[] cur = pq.peek();
                if (cur[1] != m.get(cur[0])) pq.poll();
                else break;
            }
            pq.add(new long[]{id, m.get(id)});
            res[i] = pq.peek()[1];
        }
        return res;
    }
}