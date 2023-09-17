class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Initialize the dp table for substrings of length 1 (single characters)
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        // Build the dp table for substrings of length 2 and more
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        // dp[0][n-1] contains the minimum insertions needed for the entire string
        return dp[0][n - 1];
    }
}


// class Solution {
//     public int minInsertions(String s) {
//         int dp[][]=new int[s.length()][s.length()];
//         for(int[] i:dp)Arrays.fill(i,-1);
//         return getMinInsert(s,0,s.length()-1,dp);
//     }
//     int getMinInsert(String s,int st,int end,int[][] dp)
//     {
//         if(st>=end)return 0;
//         if(dp[st][end]!=-1)return dp[st][end];

//         if(s.charAt(st)==s.charAt(end))
//         {
//             dp[st][end]=getMinInsert(s,st+1,end-1,dp);
//         }
//         else 
//         {
//             dp[st][end]=Math.min(1+getMinInsert(s,st,end-1,dp),1+getMinInsert(s,st+1,end,dp)); 
//         }
//         return dp[st][end];
//     }
// }