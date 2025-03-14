class Solution {
    private Map<String, List<String>> graph = new HashMap<>();
    private List<String> currentPath = new ArrayList<>();
    private List<List<String>> allShortestPaths = new ArrayList<>();

    private List<String> getAdjacentWords(String word, Set<String> dictionary) {
        List<String> adjacentWords = new ArrayList<>();
        char[] wordChars = word.toCharArray();

        for (int i = 0; i < wordChars.length; i++) {
            char originalChar = wordChars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;

                wordChars[i] = c;
                String newWord = new String(wordChars);

                if (dictionary.contains(newWord)) {
                    adjacentWords.add(newWord);
                }
            }

            wordChars[i] = originalChar;
        }

        return adjacentWords;
    }

    private void explorePaths(String current, String target) {
        if (current.equals(target)) {
            List<String> path = new ArrayList<>(currentPath);
            Collections.reverse(path);
            allShortestPaths.add(path);
            return;
        }

        if (!graph.containsKey(current)) return;

        for (String neighbor : graph.get(current)) {
            currentPath.add(neighbor);
            explorePaths(neighbor, target);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    private void buildGraph(String start, String end, Set<String> dictionary) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        if (dictionary.contains(start)) {
            dictionary.remove(start);
        }

        Map<String, Integer> enqueued = new HashMap<>();
        enqueued.put(start, 1);

        while (!queue.isEmpty()) {
            List<String> visitedThisLevel = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) {
                String currentWord = queue.poll();

                for (String neighbor : getAdjacentWords(currentWord, dictionary)) {
                    visitedThisLevel.add(neighbor);

                    graph.computeIfAbsent(neighbor, k -> new ArrayList<>()).add(currentWord);

                    if (!enqueued.containsKey(neighbor)) {
                        queue.add(neighbor);
                        enqueued.put(neighbor, 1);
                    }
                }
            }

            for (String word : visitedThisLevel) {
                dictionary.remove(word);
            }
        }
    }

    public List<List<String>> findLadders(String startWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        buildGraph(startWord, endWord, dictionary);

        currentPath.add(endWord);
        explorePaths(endWord, startWord);

        return allShortestPaths;
    }
}