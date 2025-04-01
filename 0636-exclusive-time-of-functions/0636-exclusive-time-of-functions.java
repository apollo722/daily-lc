class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<int[]> startTimes = new ArrayDeque<>();
        for (String input : logs) {
            String[] inputArr = input.split(":");
            int funcNum = Integer.valueOf(inputArr[0]), curTime = Integer.valueOf(inputArr[2]);
            boolean isStart = inputArr[1].equals("start");
            if (isStart) {
                startTimes.addLast(new int[]{funcNum, curTime});
            } else {
                int[] prevAction = startTimes.pollLast();
                int execTime = curTime - prevAction[1] + 1;
                if (!startTimes.isEmpty()) {
                    result[startTimes.peekLast()[0]] -= execTime;
                }
                result[funcNum] += execTime;
            }
        }
        return result;
    }
}
