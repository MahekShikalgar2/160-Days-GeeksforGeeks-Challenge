class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
      int V = adj.size();
      boolean[] visited = new boolean[V];
      ArrayList<Integer> result = new ArrayList<>();
      
      dfsUtil(0, adj, visited, result);
      return result;
        
    }
    private void dfsUtil(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result){
        visited[vertex] = true;
        result.add(vertex);
        
        for(int neighbor: adj.get(vertex)){
            if(!visited[neighbor]){
                dfsUtil(neighbor, adj, visited, result);
            }
        }
    }
}