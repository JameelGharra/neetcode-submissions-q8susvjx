class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0, maxF = 1, result = 1;
        for(int right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0)+1);
            maxF = Math.max(count.get(c), maxF);
            while((right-left+1)-maxF > k) {
                count.put(s.charAt(left), count.getOrDefault(s.charAt(left), 1)-1);
                ++left;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}
