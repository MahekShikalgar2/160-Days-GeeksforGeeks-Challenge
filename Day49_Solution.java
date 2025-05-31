class Solution {
    public int countSubarrays(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currentSum = 0;
        int count = 0;
        
        for(int num:arr){
            currentSum += num;
            if(map.containsKey(currentSum-k)){
                count += map.get(currentSum-k);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0)+1);
        }
        return count;
        
    }
}