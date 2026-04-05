class Solution {
    // O(n) - O(1) space since lower letters only
    // private static boolean isFinished(Map<Character, Integer> map, Set<Character> chars) {
    //     boolean isDone = true;
    //     for(Character c : chars) {
    //         if(map.get(c) != 0) {
    //             isDone = false;
    //             break;
    //         }
    //     }
    //     return isDone;
    // }
    // public boolean checkInclusion(String s1, String s2) {
    //     // Input: s1 = "abc", s2 = "lecabee"
    //     Set<Character> chars = new HashSet<>();
    //     Map<Character, Integer> count = new HashMap<>();
    //     for(Character c : s1.toCharArray()) {
    //         chars.add(c);
    //         count.put(c, count.getOrDefault(c, 0)+1);
    //     }
    //     int left = 0;
    //     for(int right = 0; right < s2.length(); ++right) {
    //         char current = s2.charAt(right);
    //         if(chars.contains(current)) {
    //             if(count.get(current) > 0) {  
    //                 count.put(current, count.get(current)-1);
    //                 if(isFinished(count, chars))
    //                     return true;
    //             }
    //             else { 
    //                 while(current != s2.charAt(left)) {
    //                     if(chars.contains(current))
    //                         count.put(current, count.get(current)+1);
    //                     ++left;
    //                 }
    //             }
    //         }
    //         else {
    //             while(left < right) {
    //                 if(chars.contains(s2.charAt(left))) 
    //                     count.put(s2.charAt(left), count.get(s2.charAt(left))+1);
    //                 ++left;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // Same refactored tighter
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;

        int[] count = new int[26];
        for(char c : s1.toCharArray())
            ++count[c-'a'];

        int missing = s1.length();
        int left = 0;
        for(int right = 0; right < s2.length(); ++right) {
            int c = s2.charAt(right)-'a';
            if(count[c]-- > 0) {
                --missing;
            }
            while(missing == 0) {
                if(right-left+1 == s1.length())
                    return true;
                int leftIndex = s2.charAt(left)-'a';
                if(++count[leftIndex] > 0)
                    ++missing;
                ++left;
            }
        }
        return false;
    }
}
