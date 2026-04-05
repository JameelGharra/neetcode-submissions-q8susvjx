class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String str : strs) {
            char[] toArray = str.toCharArray();
            Arrays.sort(toArray);
            String sortedStr = new String(toArray);
            groups.putIfAbsent(sortedStr, new ArrayList<>());
            groups.get(sortedStr).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}
