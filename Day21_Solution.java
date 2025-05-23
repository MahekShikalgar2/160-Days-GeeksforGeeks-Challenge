class Solution {
    public void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        
        while(mid<=high){
            if(arr[mid] == 0){
                swap(arr, low++, mid++);
            }else if(arr[mid] == 1){
                mid++;
            }else{
                swap(arr, mid, high--);
            }
        }
        
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
        
}