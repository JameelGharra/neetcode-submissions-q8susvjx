class Solution {
    // same just preprocessing for fast palindromic checks
    // O(n^2) time and space for palindromic checks which is negligable
    // since the overall time and space are way higher
    private List<List<String>> res;
    
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int d = 0; d <= n - 1; ++d) {
            for (int i = 0; i + d <= n - 1; ++i) {
                int j = i + d;
                if (d <= 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                else
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        backtrack(s, 0, new ArrayList<>(), dp);
        return res;
    }

    private void backtrack(String s, int idx, List<String> path, boolean[][] dp) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int i = idx; i < s.length(); ++i) {
            if (dp[idx][i]) {
                path.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, path, dp);
                path.remove(path.size() - 1);
            }
        }
    }
}
