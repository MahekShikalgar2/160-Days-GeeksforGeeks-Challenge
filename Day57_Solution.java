class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
       int n = arr.length;
      ArrayList<Integer> result = new ArrayList<>();
       HashMap<Integer, Integer> map = new HashMap<>();
       
       for(int i=0; i<k; i++){
           map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
       }
       result.add(map.size());
       for(int i=k; i<n; i++){
           map.put(arr[i-k], map.get(arr[i-k])-1);
           if(map.get(arr[i-k])==0){
               map.remove(arr[i-k]);
           }
           map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
           result.add(map.size());
       }
       return result;
        
    }
}