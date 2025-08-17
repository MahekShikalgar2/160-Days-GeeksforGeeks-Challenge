class Solution {
    public int findMaxSum(int arr[]) {
       int n = arr.length;
       if(n == 0)return 0;
       if(n == 1)return arr[0];
       
       int last = arr[0];
       int secondLast = 0;
       int res = arr[0];
       
       for(int i=1; i<n; i++){
           res = Math.max(arr[i] + secondLast, last);
           secondLast = last;
           last = res;
       }
       return res;
     }
}