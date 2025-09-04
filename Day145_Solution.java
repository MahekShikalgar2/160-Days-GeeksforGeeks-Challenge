class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        int time = 0;
        
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] ap = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(adj, visited, disc, low, parent, time, ap, i);
            }
        }
        for(int i=0; i<V; i++){
            if(ap[i]){
                result.add(i);
            }
        }
        if(result.isEmpty()){
            result.add(-1);
        }
        return result;
        
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] disc, int[] low, int[] parent, int time, boolean[] ap, int vertex){
        visited[vertex] = true;
        disc[vertex] = time;
        low[vertex] = time;
        time++;
        int children = 0;
        
        for(int neighbor : adj.get(vertex)){
            if(!visited[neighbor]){
                parent[neighbor] = vertex;
                children++;
                dfs(adj, visited, disc, low, parent, time, ap, neighbor);
                
                low[vertex] = Math.min(low[vertex], low[neighbor]);
                if(parent[vertex] == -1 && children > 1){
                    ap[vertex] = true;
                }
                
                if(parent[vertex] != -1 && low[neighbor] >= disc[vertex]){
                    ap[vertex] = true;
                }
            }else if(neighbor != parent[vertex]){
                low[vertex] = Math.min(low[vertex], disc[neighbor]);
                
            }
        }
    }
}