class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
    // Priority queues for workers on left and right banks, sorted by efficiency
    PriorityQueue<int[]> bankQueueLeft = new PriorityQueue<>((a, b) -> {
        if (a[0] == b[0]) return b[1] - a[1];
        return b[0] - a[0];
    });
    PriorityQueue<int[]> bankQueueRight = new PriorityQueue<>((a, b) -> b[0] - a[0]);
    
    // TreeSets to track workers waiting to be available, sorted by time
    TreeSet<int[]> waitingHandlersLeft = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
    TreeSet<int[]> waitingHandlersRight = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
    
    int bridgeTime = 0;
    
    // Initialize left bank with all workers
    for (int i = 0; i < k; ++i) {
        bankQueueLeft.offer(new int[]{time[i][0] + time[i][2], i});
    }
    
    while (n > 0 || bankQueueRight.size() + waitingHandlersRight.size() > 0) {
        // Process workers who become available on left bank
        while (!waitingHandlersLeft.isEmpty() && waitingHandlersLeft.first()[0] <= bridgeTime) {
            int[] worker = waitingHandlersLeft.pollFirst();
            int i = worker[1];
            bankQueueLeft.offer(new int[]{time[i][0] + time[i][2], i});
        }
        
        // Process workers who become available on right bank
        while (!waitingHandlersRight.isEmpty() && waitingHandlersRight.first()[0] <= bridgeTime) {
            int[] worker = waitingHandlersRight.pollFirst();
            int i = worker[1];
            bankQueueRight.offer(new int[]{time[i][0] + time[i][2], i});
        }
        
        if (!bankQueueRight.isEmpty()) {
            // Worker crossing from right to left
            int i = bankQueueRight.poll()[1];
            bridgeTime += time[i][2];
            waitingHandlersLeft.add(new int[]{bridgeTime + time[i][3], i});
        } else if (!bankQueueLeft.isEmpty() && n > 0) {
            // Worker crossing from left to right with a box
            int i = bankQueueLeft.poll()[1];
            --n;
            bridgeTime += time[i][0];
            waitingHandlersRight.add(new int[]{bridgeTime + time[i][1], i});
        } else {
            // Fast forward time to when the next worker becomes available
            int leftTime = !waitingHandlersLeft.isEmpty() && n > 0 ? waitingHandlersLeft.first()[0] : Integer.MAX_VALUE;
            int rightTime = !waitingHandlersRight.isEmpty() ? waitingHandlersRight.first()[0] : Integer.MAX_VALUE;
            bridgeTime = Math.min(leftTime, rightTime);
        }
    }
    
    return bridgeTime;
    }
}