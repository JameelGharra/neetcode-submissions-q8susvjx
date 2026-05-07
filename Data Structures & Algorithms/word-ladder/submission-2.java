class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))
            return 1;
        List<String> givenWords = new LinkedList<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int d = 0; d < size; ++d) {
                String currWord = queue.poll();
                List<Integer> removingIndices = new ArrayList<>();
                int i = 0;
                for (String word : givenWords) {
                    if (isValidDifference(word, currWord)) {
                        if (word.equals(endWord))
                            return steps + 1;
                        queue.add(word);
                        removingIndices.add(i);
                    }
                    ++i;
                }
                for (int j = 0; j < removingIndices.size(); ++j)
                    givenWords.remove(removingIndices.get(j) - j);
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
