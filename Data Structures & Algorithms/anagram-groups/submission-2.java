class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for(String str : strs) {
            char[] asChar = str.toCharArray();
            Arrays.sort(asChar);
            String sortedStr = new String(asChar);
            groupMap.putIfAbsent(sortedStr, new ArrayList<>());
            groupMap.get(sortedStr).add(str);
        }
        return new ArrayList<>(groupMap.values());
    }
}
