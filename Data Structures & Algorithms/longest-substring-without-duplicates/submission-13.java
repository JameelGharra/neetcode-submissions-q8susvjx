class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //     Map<Character, Integer> chars = new HashMap<>();
    //     int left = 0, right = 0, res = 0, current = 0;
    //     for(; right < s.length(); ++right) {
    //         Character c = new Character(s.charAt(right));
    //         if(chars.containsKey(c)) {
    //             int tillIndex = chars.get(c);
    //             while(left <= tillIndex) {
    //                 chars.remove(s.charAt(left));
    //                 ++left;
    //                 --current;
    //             }
    //         }
    //         ++current;
    //         chars.put(c, right);
    //         res = Math.max(res, current);
    //     }
    //     return res;
    // }
    
    // Same solution as above just slight optimizations
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int left = 0, right = 0, res = 0;
        for(; right < s.length(); ++right) {
            Character c = new Character(s.charAt(right));
            if(chars.containsKey(c)) {
                left = Math.max(chars.get(c)+1, left);
            }
            chars.put(c, right);
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}
