class Solution {

    public int minCoins(int coins[], int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int coin : coins){
            for(int i=coin; i<=sum; i++){
                if(dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
        
    }
}