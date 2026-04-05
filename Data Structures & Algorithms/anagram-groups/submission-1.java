class Solution {
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     Map<String, List<String>> groups = new HashMap<>();
    //     for(String str : strs) {
    //         char[] toArray = str.toCharArray();
    //         Arrays.sort(toArray);
    //         String sortedStr = new String(toArray);
    //         groups.putIfAbsent(sortedStr, new ArrayList<>());
    //         groups.get(sortedStr).add(str);
    //     }
    //     return new ArrayList<>(groups.values());
    // }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String str : strs) {
            int[] count = new int[26];
            for(char c : str.toCharArray()) {
                ++count[c-'a'];
            }
            String generatedString = Arrays.toString(count);
            groups.putIfAbsent(generatedString, new ArrayList<>());
            groups.get(generatedString).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}
