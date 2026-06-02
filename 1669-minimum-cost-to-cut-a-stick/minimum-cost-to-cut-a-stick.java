class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length-1] = n;

        for(int i=0;i<cuts.length;i++)
            arr[i+1] = cuts[i];

        int m = arr.length;
        int[][] dp = new int[m][m];

        for(int len=2;len<m;len++) {
            for(int i=0;i+len<m;i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++) {
                dp[i][j] = Math.min(dp[i][j],
                    arr[j]-arr[i] + dp[i][k] + dp[k][j]);
                }

                if(dp[i][j] == Integer.MAX_VALUE)
                    dp[i][j] = 0;
            }
        }

        return dp[0][m-1];
    }
}
