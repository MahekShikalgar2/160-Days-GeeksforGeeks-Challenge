class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int start = 0;
        int maxLength = 0;
        int startIndex = 0;
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        
        for(int end = 0; end<arr.length; end++){
            freqMap.put(arr[end], freqMap.getOrDefault(arr[end], 0) + 1);
            
            while(freqMap.lastKey() - freqMap.firstKey() > x){
                freqMap.put(arr[start], freqMap.get(arr[start]) - 1);
                if(freqMap.get(arr[start]) == 0){
                    freqMap.remove(arr[start]);
            }
            start++;
            
        }
        if(end - start + 1 >maxLength){
            maxLength = end - start + 1;
            startIndex = start;
        }
        
    }
    ArrayList<Integer> result = new ArrayList<>();
    for(int i=startIndex; i<startIndex + maxLength; i++){
        result.add(arr[i]);
    }
    return result;
    }

}