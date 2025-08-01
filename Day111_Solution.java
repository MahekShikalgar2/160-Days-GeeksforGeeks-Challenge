class Solution {
    public int longestStringChain(String words[]) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int max =0;
        
        for(String word : words){
            int best = 0;
            for(int i=0; i<word.length(); i++){
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(predecessor, 0) + 1);
            }
            dp.put(word, best);
            max = Math.max(max, best);
        }
        return max;
        
    }
}