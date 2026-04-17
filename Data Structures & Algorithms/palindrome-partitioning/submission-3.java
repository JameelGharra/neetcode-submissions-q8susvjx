class Solution {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return res;
    }
    private void backtrack(String s, int start, List<String> path) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int end = start; end < s.length(); ++end) {
            if (isPalindromic(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isPalindromic(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            ++left;
            --right;
        }
        return true;
    }
}
