class Solution {
    public String findOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new ArrayList());
                inDegree.putIfAbsent(c, 0);
            }
        }
        for(int i=0; i<words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLen = Math.min(word1.length(), word2.length());
            
            for(int j=0; j<minLen; j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                if(c1 != c2){
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    break;
                }
                if(j == minLen - 1 && word1.length() > word2.length()){
                    return "";
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for(char c : inDegree.keySet()){
            if(inDegree.get(c) == 0){
                queue.offer(c);
            }
        }
        StringBuilder order = new StringBuilder();
        while(!queue.isEmpty()){
            char c = queue.poll();
            order.append(c);
            
            for(char neighbor : graph.get(c)){
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if(inDegree.get(neighbor) == 0){
                    queue.offer(neighbor);
                }
            }
        }
        if(order.length() != graph.size()){
            return"";
        }
        return order.toString();
    }
}