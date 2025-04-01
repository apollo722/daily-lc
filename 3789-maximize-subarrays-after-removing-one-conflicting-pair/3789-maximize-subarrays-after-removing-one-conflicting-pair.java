import java.util.*;

class Solution {
    public long maxSubarrays(int N, int[][] conflictingPairs) {
        // 预处理冲突对
        List<Integer>[] right = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            right[i] = new ArrayList<>();
        }
        for (int[] pair : conflictingPairs) {
            int a = pair[0];
            int b = pair[1];
            right[Math.max(a, b)].add(Math.min(a, b));
        }

        long ans = 0; // 使用 long 存储结果
        int[] left = new int[]{0, 0}; // left[0] 是最大限制，left[1] 是第二限制
        long[] imp = new long[N + 1]; // 使用 long 存储额外子数组数量

        for (int r = 1; r <= N; r++) {
            // 更新 left
            for (int l : right[r]) {
                if (l > left[0]) {
                    left[1] = left[0];
                    left[0] = l;
                } else if (l > left[1]) {
                    left[1] = l;
                }
            }
            // 计算有效子数组
            ans += r - left[0];
            // 记录移除冲突对的影响
            imp[left[0]] += left[0] - left[1];
        }

        // 找到 imp 中的最大值
        long maxImp = 0;
        for (int i = 0; i <= N; i++) {
            if (imp[i] > maxImp) {
                maxImp = imp[i];
            }
        }

        return ans + maxImp;
    }
}