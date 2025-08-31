class Solution {
    public boolean isCycle(int V, int[][] edges) {
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for(int i=0; i<V; i++){
          adj.add(new ArrayList<>());
      }
      for(int[] edge : edges){
          adj.get(edge[0]).add(edge[1]);
          adj.get(edge[1]).add(edge[0]);
      }
      boolean[] visited = new boolean[V];
      for(int i=0; i<V; i++){
          if(!visited[i]){
              if(dfs(adj, visited, i, -1)){
                  return true;
              }
          }
      }
      return false;
        
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, int parent)
    {
        visited[node] = true;
        
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                if(dfs(adj, visited, neighbor, node)){
                    return true;
                }
            }else if(neighbor != parent){
                return true;
            }
        }
        return false;
    }
}