class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int[] res = new int[n];
        res[0] = 1;
        
        for(int i=1; i<n; i++){
            res[i] = res[i - 1] * arr[i - 1];
            
        }
        int suffixProduct = 1;
        for(int i= n - 1; i >= 0; i-- ){
            res[i] *= suffixProduct;
            suffixProduct *= arr[i];
        }
        return res;
    }
}
