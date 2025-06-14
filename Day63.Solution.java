class Solution {
    public int maxLen(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int maxLength = 0;
        
        for(int i=0; i<arr.length; i++){
            count += (arr[i] == 0) ? -1 : 1;
            
            if(map.containsKey(count)){
                maxLength = Math.max(maxLength, i-map.get(count));
            } else{
                map.put(count, i);
            }
        }
        return maxLength;
        
    }
}