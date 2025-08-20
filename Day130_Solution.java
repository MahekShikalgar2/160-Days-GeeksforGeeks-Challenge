class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        for(int length =2; length<n; length++){
            for(int i=0; i<n-length; i++){
                int j = i + length;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i + 1; k<j; k++){
                    int cost = dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][n - 1];
        
    }
}