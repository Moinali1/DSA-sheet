//memoization
class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        return findIsMatch(s, p, 0, 0, dp);
    }

    public boolean findIsMatch(String s, String p, int sIdx, int pIdx, boolean[][] dp) {
        if (sIdx == s.length() && pIdx == p.length()) return dp[sIdx][pIdx] = true;
        if (pIdx == p.length()) return dp[sIdx][pIdx] = false;
        if (dp[sIdx][pIdx]) return true;

        boolean match = (sIdx < s.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.'));

        if (pIdx + 1 < p.length() && p.charAt(pIdx + 1) == '*') {
            boolean case1=findIsMatch(s, p, sIdx, pIdx + 2, dp);
            boolean case2= match && findIsMatch(s, p, sIdx + 1, pIdx, dp);
            dp[sIdx][pIdx] = case1 || case2;
        } 
        else if(match) {
            dp[sIdx][pIdx] = findIsMatch(s, p, sIdx + 1, pIdx + 1, dp);
        }
        else dp[sIdx][pIdx]=false;

        return dp[sIdx][pIdx];
    }
}