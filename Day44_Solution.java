class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
       List<List<Integer>> result = new ArrayList<>();
     
       for(int i=0; i<arr.length; i++){
         
              for(int j=i+1; j<arr.length; j++){
                  for(int k=j+1; k<arr.length; k++){
                      if(arr[i]+arr[j]+arr[k]==0){
                          result.add(Arrays.asList(i, j, k));
                      }
                  }
              }
       }
       return result;
    }
        
}