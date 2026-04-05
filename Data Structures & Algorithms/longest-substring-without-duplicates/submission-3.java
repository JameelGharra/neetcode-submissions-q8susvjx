class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int left = 0, right = 1, result = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while(right < s.length()) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            result = Math.max(result, right-left+1);
            ++right;
        }
        return result;
    }
}
