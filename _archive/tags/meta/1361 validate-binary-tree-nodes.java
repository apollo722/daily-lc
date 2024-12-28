/*
https://leetcode.com/problems/validate-binary-tree-nodes/

拓扑排序，入度为0的只能有一个，且最后要能够成完整的树，且每个节点的入度不能超过1

Time: O(n)
Space: O(n)
*/

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            int left = leftChild[i], right = rightChild[i];
            if (left != -1) {
                indegree[left]++;
                if (indegree[left] > 1) return false;
            }
            if (right != -1) {
                indegree[right]++;
                if (indegree[right] > 1) return false;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        if (q.size() > 1) return false;
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            int cur = q.poll();
            int left = leftChild[cur], right = rightChild[cur];
            if (left != -1) {
                indegree[left]--;
                if (indegree[left] == 0) q.add(left);
            }
            if (right != -1) {
                indegree[right]--;
                if (indegree[right] == 0) q.add(right);
            }
        }
        return n == cnt;
    }
}