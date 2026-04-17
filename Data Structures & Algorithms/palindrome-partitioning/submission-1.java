class Solution {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), new StringBuilder());
        return res;
    }

    private void backtrack(String s, int idx, List<String> path, StringBuilder sb) {
        if (idx == s.length()) {
            for (String str : path) {
                if (!isPalindromic(str)) {
                    return;
                }
            }
            res.add(new ArrayList<>(path));
            return ;
        }
        sb.append(s.charAt(idx));
        if (idx != s.length() - 1)
            backtrack(s, idx + 1, path, sb);
        path.add(sb.toString());
        sb.deleteCharAt(sb.length() - 1);
        backtrack(s, idx + 1, path, new StringBuilder());
        path.remove(path.size() - 1);
    }
    private boolean isPalindromic(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            ++left;
            --right;
        }
        return true;
    }
}
