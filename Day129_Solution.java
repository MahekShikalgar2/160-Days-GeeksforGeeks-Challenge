class Solution {
    public int countWays(String digits) {
        int n = digits.length();
        if(n == 0 || digits.charAt(0) == '0')return 0;
        
        int[] dp = new int [n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            if(digits.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }
            if(digits.charAt(i - 2) == '1' || (digits.charAt(i - 2) == '2' && digits.charAt(i - 1) <= '6')){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
        
    }
}