/*
https://leetcode.com/problems/design-search-autocomplete-system/

Trie模板
用trie存储每一个新输入的query和existing query，注意的是要在每一个节点存储后续节点的所有结果，这样才能query出来
query的时候用pq来筛选出3个结果即可

Time:
Space:
*/

class AutocompleteSystem {
    class Trie {
        class Node {
            HashMap<Character, Node> next;
            HashMap<String, Integer> m;
            public Node() {
                next = new HashMap<>();
                m = new HashMap<>();
            }
        }
        Node root;
        public Trie() {
            root = new Node();
        }
        
        public void add(String s, int cnt) {
            Node node = root;
            for (char c : s.toCharArray()) {
                if (!node.next.containsKey(c)) node.next.put(c, new Node());
                node = node.next.get(c);
                node.m.put(s, node.m.getOrDefault(s, 0) + cnt);
            }
        }

        public List<String> get(String s) {
            Node node = root;
            for (char c : s.toCharArray()) {
                if (!node.next.containsKey(c)) return new ArrayList<>();
                node = node.next.get(c);
            }
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(3, (a, b) -> {
                if (a.getValue() == b.getValue()) return b.getKey().compareTo(a.getKey());
                return a.getValue() - b.getValue();
            });
            for (Map.Entry<String, Integer> e : node.m.entrySet()) {
                pq.add(e);
                if (pq.size() > 3) pq.poll();
            }
            List<String> res = new LinkedList<>();
            while (!pq.isEmpty()) res.add(pq.poll().getKey());
            Collections.reverse(res);
            return res;
            
        }
    }
    StringBuilder input;
    Trie trie;
    public AutocompleteSystem(String[] sentences, int[] times) {
        input = new StringBuilder();
        trie = new Trie();
        for (int i = 0; i < times.length; i++) {
            trie.add(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            trie.add(input.toString(), 1);
            input = new StringBuilder();
            return new ArrayList<>();
        } else {
            input.append(c);
            return trie.get(input.toString());
        }
    }
}