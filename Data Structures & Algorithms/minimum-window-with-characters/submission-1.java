class Solution {
    // Same as below just not tighter - more space same analysis
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> windowCount = new HashMap<>();
        for(Character c : t.toCharArray())
            countT.put(c, countT.getOrDefault(c, 0)+1);
        int left = 0, minLength = s.length()+1, minLeft = -1;
        int need = t.length(), have = 0;
        for(int right = 0; right < s.length(); ++right) {
            Character c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0)+1);
            if(countT.containsKey(c)) {
                if(countT.get(c) >= windowCount.get(c))
                    ++have;
            }
            while(need == have) {
                if(minLength > right-left+1) {
                    minLength = right-left+1;
                    minLeft = left;
                }
                Character leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar)-1);
                if(countT.containsKey(leftChar)) {
                    if(windowCount.get(leftChar) < countT.get(leftChar))
                        --have;
                }
                ++left;
            }
        }
        if(minLength <= s.length())
            return s.substring(minLeft, minLeft+minLength);
        return "";
    }

    // O(n+m) - O(j) where j is number of distinct chars in t string can
    // be O(m) at worst.
    // public String minWindow(String s, String t) {
    //     if(s.length() < t.length())
    //         return "";

    //     Map<Character, Integer> count = new HashMap<>();
    //     for(Character c : t.toCharArray())
    //         count.put(c, count.getOrDefault(c, 0)+1);
    //     int left = 0, minLength = s.length()+1, minLeft = 0;
    //     int missing = t.length();
    //     for(int right = 0; right < s.length(); ++right) {
    //         Character c = s.charAt(right);
    //         if(count.containsKey(c)) {
    //             if(count.get(c) > 0)
    //                 --missing;
    //             count.put(c, count.get(c)-1);
    //         }
    //         while(missing == 0) {
    //             if(right-left+1 < minLength) {
    //                 minLeft = left;
    //                 minLength = right-left+1;
    //             }
    //             Character leftChar = s.charAt(left);
    //             if(count.containsKey(leftChar)) {
    //                 if(count.get(leftChar) >= 0) {
    //                     ++missing;
    //                 }
    //                 count.put(leftChar, count.get(leftChar)+1);
    //             }
    //             ++left;
    //         }
    //     }
    //     if(minLength <= s.length())
    //         return s.substring(minLeft, minLeft+minLength);
        
    //     return "";
    // }
}
