class Solution {
 
    public int characterReplacement(String s, int k) {
        if(s.length() == 0)
            return 0;
        int result = 1;
        for(int i = 0; i < s.length(); ++i) {
            Map<Character, Integer> count = new HashMap<>();
            int maxF = 1;
            for(int j = i; j < s.length(); ++j) {
                char c = s.charAt(j);
                count.put(c, count.getOrDefault(c, 0)+1);
                maxF = Math.max(maxF, count.get(c));
                if((j-i+1) - maxF <= k)
                    result = Math.max(result, j-i+1);
            }
        }
        return result;
    }

    // O(n) - O(m) where m is distinct characters
    // public int characterReplacement(String s, int k) {
    //     Map<Character, Integer> count = new HashMap<>();
    //     int left = 0, maxF = 1, result = 1;
    //     for(int right = 0; right < s.length(); ++right) {
    //         char c = s.charAt(right);
    //         count.put(c, count.getOrDefault(c, 0)+1);
    //         maxF = Math.max(count.get(c), maxF);
    //         while((right-left+1)-maxF > k) {
    //             count.put(s.charAt(left), count.getOrDefault(s.charAt(left), 1)-1);
    //             ++left;
    //         }
    //         result = Math.max(result, right-left+1);
    //     }
    //     return result;
    // }
}
