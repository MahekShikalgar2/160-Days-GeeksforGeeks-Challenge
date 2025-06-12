class Solution {
    public static int findEquilibrium(int arr[]) {
       int n = arr.length;
       int totalSum = 0;
       
       for(int i=0; i<n; i++){
           totalSum += arr[i];
       }
       int leftSum = 0;
       for(int i=0; i<n; i++){
           if(leftSum == totalSum - leftSum - arr[i]){
               return i;
           }
           leftSum += arr[i];
       }
       return -1;
    }
}
