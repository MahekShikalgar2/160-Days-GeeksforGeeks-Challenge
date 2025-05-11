int maxSubarraySum(int[] arr) {  // remove n
    int n = arr.length;          // calculate inside function
    int max_so_far = arr[0];
    int current_max = arr[0];
    
    for (int i = 1; i < n; i++) {
        current_max = Math.max(arr[i], current_max + arr[i]);
        max_so_far = Math.max(max_so_far, current_max);
    }
    
    return max_so_far;
}
