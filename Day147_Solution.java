class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
            
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
                adj.get(edge[1]).add(new int[] { edge[0], edge[2]});
            }
            
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.offer(new int[] { src, 0});
            
            while(!pq.isEmpty()){
                int[] curr = pq.poll();
                int u = curr[0];
                int d = curr[1];
                
                for(int[] neighbor : adj.get(u)){
                    int v = neighbor[0];
                    int w = neighbor[1];
                    if(d + w < dist[v]){
                        dist[v] = d + w;
                        pq.offer(new int[] { v, dist[v]});
                    }
                }
            }
            return dist;
        }
        
    }
