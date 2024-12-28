/*
https://leetcode.com/problems/sort-vowels-in-a-string/

找到所有元音位置，并把它们排序再放回结果
（有更优算法，统计位置O(n)）

Time: O(nlogn)
Space: O(n)
*/

class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        HashSet<Character> set = new HashSet<>(vowels);
        HashSet<Integer> idxSet = new HashSet<>();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (set.contains(c)) {
                idxSet.add(i);
                pq.add(c);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (idxSet.contains(i)) {
                arr[i] = pq.poll();
            }
        }
        return new String(arr);
    }
}