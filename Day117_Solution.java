class Solution {
    int countWays(int n) {
        int mod = 1000000007;
        if(n == 1) return 1;
        long a = 1, b = 1;
        for(int i = 2; i <= n; i++){
            long temp = (a + b) % mod;
            a = b;
            b = temp;
        }
        return (int) b;
       
        
    }
}
