class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        HashMap<Integer, Integer>prefixSum = new HashMap<>();
        int sum = 0;
        prefixSum.put(0, -1);
        
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            
            if(prefixSum.containsKey(sum-target)){
               ArrayList<Integer> result = new ArrayList<>();
               result.add(prefixSum.get(sum-target)+2);
               result.add(i+1);
               return result;
            }
            if(!
            prefixSum.containsKey(sum)){
                prefixSum.put(sum, i);
            }
        }
       ArrayList<Integer> result = new ArrayList<>();
       result.add(-1);
       return result;
    }
}

        