class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int time = 0, prev = -1, i = 0, n = arrival.length;
        int[] res = new int[n];
        Queue<Integer> enterQueue = new ArrayDeque<>();
        Queue<Integer> exitQueue = new ArrayDeque<>();

        while (i < n || !enterQueue.isEmpty() || !exitQueue.isEmpty()) {
            while (i < n && arrival[i] <= time) {
                if (state[i] == 0) {
                    enterQueue.offer(i);
                } else {
                    exitQueue.offer(i);
                }
                i++;
            }
            
            if (enterQueue.isEmpty() && exitQueue.isEmpty()) {
                time = arrival[i];
                prev = -1;
                continue;
            }
            
            int idx;
            if (prev == -1 || prev == 1) {
                if (!exitQueue.isEmpty()) {
                    idx = exitQueue.poll();
                    prev = 1;
                } else {
                    idx = enterQueue.poll();
                    prev = 0;
                }
            } else { 
                if (!enterQueue.isEmpty()) {
                    idx = enterQueue.poll();
                    prev = 0;
                } else {
                    idx = exitQueue.poll();
                    prev = 1;
                }
            }
            res[idx] = time;
            time++;
        }
        
        return res;
    }
}


/*
题目看着比较复杂，实际思路比较清晰。
每一个时刻，需要做两件事：
1. 把这一时刻到达的人都收集起来，放到等待区；
2. 让一个等待区里符合规则的人通过。

对于整个问题，最终的解答就是所有的人都进过等待区且都已经通过了，即没有人在等待区了。
所以先看哪些人能进等待区，即到达时间早于或等于当前时刻的人都分别进入出入门的等待区。

如果等待区都没有人，证明现在的时刻太早了，还没人来，直接跳到下一个人来的时间，并且把门的前状态置为-1，即上一个时刻没用到。

这时候等待区有了人，就开始按照规则放人通过。
如果门之前没用过，即-1，那么要让出门等待区的人过1个（如果出门等待区有人的话）。该情况和之前门被用作出来是一样的，故合并处理。
如果出门等待区没人，那就让进门等待区的人进来1个。两种可能性分别将门的状态置成各自对应的行为。

如果之前门是用来进入（因为没用过和用来出来已经在上面都处理了，就剩下这一种情况了），那么优先看进门等待区。
处理同上。

之后把要处理的等待区的人的结果设置成当前时间，之后增加时间即可。
*/