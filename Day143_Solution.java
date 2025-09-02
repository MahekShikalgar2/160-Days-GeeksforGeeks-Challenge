class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        
        int[] inDegree = new int[V];
        for(int i=0; i<V; i++){
            for(int neighbor : adj.get(i)){
                inDegree[neighbor]++;
            }
        }
    
    Queue<Integer> queue = new LinkedList<>();
    for(int i=0; i<V; i++){
        if(inDegree[i] == 0){
            queue.add(i);
        }
    }
    ArrayList<Integer> result = new ArrayList<>();
    while(!queue.isEmpty()){
        int vertex = queue.poll();
        result.add(vertex);
        
        for(int neighbor : adj.get(vertex)){
            inDegree[neighbor]--;
            if(inDegree[neighbor] == 0){
                queue.add(neighbor);
            }
        }
    }
    if(result.size() != V){
        return new ArrayList<>();
    }
    return result;
    }

}