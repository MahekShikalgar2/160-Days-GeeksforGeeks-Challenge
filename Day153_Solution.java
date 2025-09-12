class Solution {
    static class Pair implements Comparable<Pair> {
        int node;
        int weight;
        
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
        public int compareTo(Pair other){
            return Integer.compare(this.weight, other.weight);
        }
    }
    public int findMinCycle(int V, int[][] edges){
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<V; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        int minCycle = Integer.MAX_VALUE;
        
        for(int[] edge : edges){
            int u = edge[0], v=edge[1], w=edge[2];
            
            graph.get(u).removeIf(p -> p.node == v && p.weight == w);
            graph.get(v).removeIf(p -> p.node == u && p.weight == w);
            
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[u] = 0;
            
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.offer(new Pair(u, 0));
            
            while(!pq.isEmpty()){
                Pair curr = pq.poll();
                int node = curr.node;
                int weight = curr.weight;
                
                if(weight > dist[node]){
                    continue;
                }
                for(Pair neighbor : graph.get(node)){
                    if(dist[neighbor.node] > weight + neighbor.weight){
                        dist[neighbor.node] = weight + neighbor.weight;
                        pq.offer(new Pair(neighbor.node, dist[neighbor.node]));
                    }
                }
           }
                    if(dist[v] != Integer.MAX_VALUE){
                        minCycle = Math.min(minCycle, dist[v] + w);
                    }
                
                graph.get(u).add(new Pair(v, w));
                graph.get(v).add(new Pair(u, w));
                
                }
                
                return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
            }
        }
      
