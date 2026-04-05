class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";

        Map<Character, Integer> count = new HashMap<>();
        for(Character c : t.toCharArray())
            count.put(c, count.getOrDefault(c, 0)+1);
        int left = 0, minLength = s.length()+1, minLeft = 0;
        int missing = t.length();
        for(int right = 0; right < s.length(); ++right) {
            Character c = s.charAt(right);
            if(count.containsKey(c)) {
                if(count.get(c) > 0)
                    --missing;
                count.put(c, count.get(c)-1);
            }
            while(missing == 0) {
                if(right-left+1 < minLength) {
                    minLeft = left;
                    minLength = right-left+1;
                }
                Character leftChar = s.charAt(left);
                if(count.containsKey(leftChar)) {
                    if(count.get(leftChar) >= 0) {
                        ++missing;
                    }
                    count.put(leftChar, count.get(leftChar)+1);
                }
                ++left;
            }
        }
        if(minLength <= s.length())
            return s.substring(minLeft, minLeft+minLength);
        
        return "";
    }
}
