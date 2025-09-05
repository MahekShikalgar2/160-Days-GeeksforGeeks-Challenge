class Solution {
    static class Edge implements Comparable<Edge>{
        int u, v, weight;
    
    public Edge(int u, int v, int weight){
        this.u= u;
        this.v = v;
        this.weight = weight;
    }
    public int compareTo(Edge other){
        return Integer.compare(this.weight, other.weight);
    }
}
static class DisjointSet{
    int[] parent, rank;
    
    public DisjointSet(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }
    int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

    public int minCost(int[][] houses) {
        int n = houses.length;
        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i + 1; j<n; j++){
                int weight = Math.abs(houses[i][0] - houses[j][0]) + Math.abs(houses[i][1] - houses[j][1]);
                edges.add(new Edge(i, j, weight));
            }
        }
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(n);
        int cost = 0;
        int edgeCount = 0;
        
        for(Edge edge : edges){
            if(ds.find(edge.u) != ds.find(edge.v)){
                cost += edge.weight;
                ds.union(edge.u, edge.v);
                edgeCount++;
                if(edgeCount == n - 1){
                    break;
                }
            }
        }
        return cost;
        
    }
}
