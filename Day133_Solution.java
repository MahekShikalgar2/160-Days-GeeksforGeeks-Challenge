class Solution {
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int plat_needed = 1;
        int result = 1;
        int i = 1;
        int j = 0;
        
        while(i<arr.length && j<dep.length){
            if(arr[i] <= dep[j]){
                plat_needed++;
                i++;
                result = Math.max(result, plat_needed);
                
            }else{
                plat_needed--;
                j++;
            }
        }
        return result;
        
    }
}
