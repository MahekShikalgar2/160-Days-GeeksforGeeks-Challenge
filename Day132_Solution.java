class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>();
        for(String word : dictionary){
            dict.add(word);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}