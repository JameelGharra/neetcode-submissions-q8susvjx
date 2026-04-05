class Solution {
    // HashSet: O(n) - O(m) where m distinct characters
    // public int lengthOfLongestSubstring(String s) {
    //     if(s.length() == 0)
    //         return 0;
    //     int left = 0, right = 1, result = 1;
    //     Set<Character> set = new HashSet<>();
    //     set.add(s.charAt(0));
    //     while(right < s.length()) {
    //         while(set.contains(s.charAt(right))) {
    //             set.remove(s.charAt(left++));
    //         }
    //         set.add(s.charAt(right));
    //         result = Math.max(result, right-left+1);
    //         ++right;
    //     }
    //     return result;
    // }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        Map<Character, Integer> indexer = new HashMap<>();
        int left = 0, result = 1;
        indexer.put(s.charAt(0), 0);
        for(int right = 1; right < s.length(); ++right) {
            int savedIndex = indexer.getOrDefault(s.charAt(right), -1);
            if(savedIndex >= left) {
                left = savedIndex+1;
            }
            indexer.put(s.charAt(right), right);
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}
