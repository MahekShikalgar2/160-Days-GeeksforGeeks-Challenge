lass Solution {
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;
        int totalSum = 0;
        int maxNormal = kadane(arr, n);
        
        if(maxNormal < 0)return maxNormal;
        
        for(int i=0; i<n; i++){
            totalSum += arr[i];
            arr[i] = -arr[i];
        }
        
        int maxCircular = totalSum + kadane(arr, n);
        return Math.max(maxNormal, maxCircular);
    }
    int kadane(int arr[], int n){
        int maxEnd = arr[0], maxSoFar = arr[0];
        for (int i=1; i<n; i++){
            maxEnd = Math.max(arr[i], maxEnd + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEnd);
        }
        return maxSoFar;
    }
}
