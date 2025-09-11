class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    long d = (long) dist[i][k] + (long) dist[k][j];
                    if(dist[i][k] != (int) 1e8 && dist[k][j] != (int) 1e8 && d<dist[i][j]){
                        dist[i][j] = (int) d;
                    }
                }
            }
        }
        
        
    }
}