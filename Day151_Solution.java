class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        for(int i=0; i<V; i++){
            dist[i] = 100000000;
        }
        dist[src] = 0;
        
        for(int i=0; i<V - 1; i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                
                if(dist[u] !=  100000000 && dist[u] + w<dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if(dist[u] != 100000000 && dist[u] + w<dist[v]){
                return new int[]{-1};
            }
        }
        for(int i=0; i<V; i++){
            if(dist[i] == 100000000){
                dist[i] = (int) 1e8;
            }
        }
        return dist;
    }
}
