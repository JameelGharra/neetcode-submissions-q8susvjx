class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))
            return 1;
        Set<String> givenWords = new HashSet<>(wordList);
        if (!givenWords.contains(endWord))
            return 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        givenWords.remove(beginWord);
        int steps = 1, n = beginWord.length();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String word = queue.poll();
                char[] charArray = word.toCharArray();
                for (int pos = 0; pos < n; ++pos) {
                    char originalChar = charArray[pos];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == originalChar)
                            continue;
                        charArray[pos] = c;
                        String nextWord = new String(charArray);
                        if (nextWord.equals(endWord))
                            return steps + 1;
                        if (givenWords.contains(nextWord)) {
                            queue.offer(nextWord);
                            givenWords.remove(nextWord);
                        }
                    }
                    charArray[pos] = originalChar;
                }
            }
            ++steps;
        }
        return 0;
    }
}
