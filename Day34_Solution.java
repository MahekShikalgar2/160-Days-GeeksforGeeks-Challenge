
class Solution {
    
    private static boolean isPossible(int[] arr, int k, int maxPages){
        int students = 1;
        int currentSum = 0;
        
        for(int pages : arr){
            if(pages > maxPages) return false;
            
            if(currentSum + pages > maxPages){
                students++;
                currentSum = pages;
            }else{
                currentSum += pages;
            }
        }
        return students <= k;
    }
    
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if(k > n)return -1;
        
        int low = 0, high = 0;
        for(int pages : arr){
            low = Math.max(low, pages);
            high += pages;
        }
        
        int result = high;
        while(low <= high){
            int mid = low +(high - low)/2;
            
            if(isPossible(arr, k, mid)){
                result = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }
}