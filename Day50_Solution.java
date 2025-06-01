class Solution {
    public long subarrayXor(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currentXOR = 0;
        int count = 0;
        
        for(int num:arr){
            currentXOR ^= num;
            if(map.containsKey(currentXOR ^ k)){
                count += map.get(currentXOR ^ k);
            }
            map.put(currentXOR, map.getOrDefault(currentXOR, 0)+1);
        }
        return count;
        
    }
}