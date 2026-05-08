class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))
            return 1;
        Queue<String> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[wordList.size()];
        queue.offer(beginWord);
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int d = 0; d < size; ++d) {
                String currWord = queue.poll();
                for (int i = 0; i < wordList.size(); ++i) {
                    if (visited[i])
                        continue;
                    String word = wordList.get(i);
                    if (isValidDifference(word, currWord)) {
                        if (word.equals(endWord))
                            return steps + 1;
                        visited[i] = true;
                        queue.add(word);
                    }
                }
            }
            ++steps;
        }
        return 0;
    }
    private boolean isValidDifference(String str1, String str2) {
        boolean foundDiff = false;
        for (int i = 0; i < str1.length(); ++i) {
            if (str1.charAt(i) != str2.charAt(i) && foundDiff)
                return false;
            else if (str1.charAt(i) != str2.charAt(i))
                foundDiff = true;
        }
        return true;
    }
}
