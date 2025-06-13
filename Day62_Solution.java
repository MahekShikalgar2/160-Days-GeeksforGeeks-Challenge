class Solution {
    public int longestSubarray(int[] arr, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0, -1);
       int sum = 0;
       int maxLength = 0;
       
       for(int i=0; i<arr.length; i++){
           sum += arr[i];
           if(map.containsKey(sum - k)){
               maxLength = Math.max(maxLength, i-map .get(sum-k));
           }
           if(!map.containsKey(sum)){
               map.put(sum, i);
           }
       }
       return maxLength;
        
    }
}
