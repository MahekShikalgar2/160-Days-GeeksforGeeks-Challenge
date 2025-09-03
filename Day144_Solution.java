class Solution {
    public boolean isCyclic(int V, int[][] edges) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for(int i=0; i<V; i++){
           adj.add(new ArrayList<>());
       }
       for(int[] edge : edges){
           adj.get(edge[0]).add(edge[1]);
       }
       
       boolean[] visited = new boolean[V];
       boolean[] recursionStack = new boolean[V];
       
       for(int i=0; i<V; i++){
           if(!visited[i]){
               if(isCyclicUtil(adj, visited, recursionStack, i)){
                   return true;
               }
           }
       }
       return false;
        
    }
    
    private boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recursionStack, int vertex){
        visited[vertex] = true;
        recursionStack[vertex] = true;
        
        for(int neighbor : adj.get(vertex)){
            if(!visited[neighbor]){
                if(isCyclicUtil(adj, visited, recursionStack, neighbor)){
                    return true;
                }
            } else if(recursionStack[neighbor]){
                return true;
            }
        }
            recursionStack[vertex] = false;
            return false;
        }
    }
