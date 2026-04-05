class Solution {
    // O(N) - O(M) where m is the number of unique characters
    public int characterReplacement(String s, int k) {
        if(s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> count = new HashMap<>();
        int left = 0, res = 0, countMostFreq = 0;
        for(int i = 0; i < s.length(); ++i) {
            Character current = s.charAt(i);
            count.put(current, count.getOrDefault(current, 0)+1);
            int countCurrent = count.get(current);
            countMostFreq = Math.max(countCurrent, countMostFreq);
            if(k < i - left + 1 - countMostFreq) {
                char c = s.charAt(left);
                count.put(c, count.get(c)-1);
                ++left;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
    }

    // This one is actually worse O(n*m) - O(m) but I want to try it
    // public int characterReplacement(String s, int k) {
    //     if(s.length() == 0) {
    //         return 0;
    //     }
    //     Set<Character> uniqueChars = new HashSet<>();
    //     for(Character c : s.toCharArray()) {
    //         uniqueChars.add(c);
    //     }
    //     int res = 0;
    //     for(char c : uniqueChars) {
    //         int left = 0, count = 0;
    //         for(int i = 0; i < s.length(); ++i) {
    //             char currentChar = s.charAt(i);
    //             if(currentChar != c) {
    //                 ++count;
    //                 while(count > k) {
    //                     if(s.charAt(left) != c) {
    //                         --count;
    //                     }
    //                     ++left;
    //                 }
    //             }
    //             res = Math.max(res, i-left+1);
    //         }
    //     }
    //     return res;
    // }
}
