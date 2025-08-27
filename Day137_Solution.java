class Solution {
    public int maxPartitions(String s) {
        int[] lastOccurrence = new int[26];
        for(int i=0; i<s.length(); i++){
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        int partitionCount = 0;
        int maxLastOccurrence = -1;
        for(int i=0; i<s.length(); i++){
            maxLastOccurrence = Math.max(maxLastOccurrence, lastOccurrence[s.charAt(i) - 'a']);
            if(i == maxLastOccurrence){
                partitionCount++;
                maxLastOccurrence = -1;
            }
        }
        return partitionCount;
    }
}