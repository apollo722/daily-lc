/*
https://leetcode.com/problems/moving-stones-until-consecutive-ii/

每日一题：https://www.youtube.com/watch?v=wUKFV55eqHE

最大move相对易于理解，即每次都要用最不划算的方式移动石头
如果两端的石头已经有相邻的情况，即

00.0..0

那么直接计算端点之间的空隙即可

如果两端的石头有缝隙，即

0.00..0

那么首先要消除其中一端的缝隙，因为只有存在一端没有缝隙的情况，move没有缝隙的那端才能不断地填满剩下的缝隙
既然要消除其中的一端，那就要消除缝隙更小的，这样消除后剩下的空隙更多，如上面的例子就要消除左边

最小move可以用sliding window找到长度为n，尽可能cover更多stone的window
这时有两种情况
如果尾端（首端一定是有石头的，因为sliding window要固定一端，所以起点有石头）没有石头，此时最少move不能少于2
这是因为比如

000.0 

sliding window size为4，用1次move把最右的石头移动到slot并不合法，因为移动后它仍为end stone
所以此时一定要先移动某个石头，构造出一个边缘不为空的window才行，所以至少是2步

其实如果上面例子把最左边石头直接移动到slot是合法的，而且只需要1步，但是这样相当于移动了window的起始点

只需要1步的move在下一个石头作为起始点会被计算到，即为第二种情况，window最右端有石头
此时只要计算window之外有多少石头，把他们都移动进来即可

运行起来没有答案里面的效率高，但是易于理解

class Solution {
  public int[] numMovesStonesII(int[] stones) {
    Arrays.sort(stones);
    int N = stones.length;
    
    int maxMoves = Math.max(stones[N-1] - stones[1] - N + 2, 
                           stones[N-2] - stones[0] - N + 2);
    int minMoves = N;

    // Calculate minimum moves through sliding window.
    int start = 0;
    for (int end = 0; end < N; end++) {
      while (stones[end] - stones[start] + 1 > N) {
        start++;
      }

      if (end - start + 1 == N - 1 && stones[end] - stones[start] + 1 == N - 1) {
        // Case: N - 1 stones with N - 1 positions.
        minMoves = Math.min(minMoves, 2); 
      } else {
        minMoves = Math.min(minMoves, N - (end - start + 1));
      }
    }
    
    return new int[]{minMoves, maxMoves};
  }
}

Time: O(nlogn)
Space: O(1)
*/

class Solution {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length, l = 0, r = 0, minMove = Integer.MAX_VALUE;
        if (n < 3) return null;
        Arrays.sort(stones);
        while (r < n) {
            int slot = stones[r] - stones[l] + 1;
            while (slot >= n) {
                int end = stones[l] + n - 1;
                int right = stones[r] > end ? n - r : n - r - 1;
                int left = l;
                if (stones[r] != end) minMove = Math.min(minMove, Math.max(2, left + right));
                else minMove = Math.min(minMove, left + right);
                slot = stones[r] - stones[++l] + 1;
            }
            r++;
        }
        int maxMove = 0;
        if (stones[n - 1] - stones[n - 2] > stones[1] - stones[0]) {
            maxMove = stones[n - 1] - stones[1] + 1 - (n - 1 - 1 + 1);
        } else {
            maxMove = stones[n - 2] - stones[0] + 1 - (n - 2 - 0 + 1);
        }
        return new int[]{minMove, maxMove};
    }
}