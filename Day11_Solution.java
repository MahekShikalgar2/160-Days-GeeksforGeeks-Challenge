class Solution {
    // Function to find the maximum product subarray
    int maxProduct(int[] arr, int n) {
        // Initialize max, min, and result to the first element
        int max_so_far = arr[0];
        int min_so_far = arr[0];
        int result = arr[0];

        for (int i = 1; i < n; i++) {
            // If current element is negative, swap max and min
            if (arr[i] < 0) {
                int temp = max_so_far;
                max_so_far = min_so_far;
                min_so_far = temp;
            }

            // Calculate max and min ending at current index
            max_so_far = Math.max(arr[i], max_so_far * arr[i]);
            min_so_far = Math.min(arr[i], min_so_far * arr[i]);

            // Update the result
            result = Math.max(result, max_so_far);
        }

        return result;
    }
}
