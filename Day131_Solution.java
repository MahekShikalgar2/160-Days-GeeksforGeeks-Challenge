class Solution {
    static int countWays(String s) {
        int n = s.length();
        int[][] trueDP = new int[n][n];
        int[][] falseDP = new int[n][n];
        
        for(int i=0; i<n; i+=2){
            if(s.charAt(i) == 'T'){
                trueDP[i][i] = 1;
                falseDP[i][i] = 0;
            }else{
                trueDP[i][i] = 0;
                falseDP[i][i] = 1;
            }
        }
        for(int length = 3; length<=n; length+=2){
            for(int i=0; i<=n-length; i+=2){
                int j = i + length - 1;
                trueDP[i][j] = 0;
                falseDP[i][j] = 0;
                for(int k = i + 1; k < j; k += 2){
                    int totalWays = trueDP[i][k - 1] + falseDP[i][k - 1];
                    int totalWays2 = trueDP[k + 1][j] + falseDP[k + 1][j];
                    if(s.charAt(k) == '&'){
                        trueDP[i][j] += trueDP[i][k - 1] * trueDP[k + 1][j];
                        falseDP[i][j] += trueDP[i][k - 1] * falseDP[k + 1][j] + falseDP[i][k - 1] * totalWays2;;
                    }else if(s.charAt(k) == '|'){
                            trueDP[i][j] += trueDP[i][k - 1] * trueDP[k + 1][j] + trueDP[i][k - 1] * falseDP[k + 1][j] + falseDP[i][k - 1] *
                            trueDP[k + 1][j];                            
                            falseDP[i][j] += falseDP[i][k - 1] * falseDP[k + 1][j];
                        }else if(s.charAt(k) == '^'){
                                trueDP[i][j] += trueDP[i][k - 1] * falseDP[k + 1][j] + falseDP[i][k - 1] * trueDP[k + 1][j];
                                falseDP[i][j] += trueDP[i][k - 1] * trueDP[k + 1][j] + falseDP[i][k - 1] * falseDP[k + 1][j];
                        }
                    }
                }
            }
            return trueDP[0][n - 1];
    }
}