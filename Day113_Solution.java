class Solution {
    public int longestPalinSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return lcs(s, rev);
        
    }
    public int lcs(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    curr[j] = prev[j - 1] + 1;
                }else{
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[n];
    }
}