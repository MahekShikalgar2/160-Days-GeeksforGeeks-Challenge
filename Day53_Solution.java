class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        int closestDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        boolean found = false;
        
        while(left<right){
            int sum = arr[left]+arr[right];
            int diff = Math.abs(sum-target);
            
            if(diff<closestDiff){
                closestDiff = diff;
                result[0] = arr[left];
                result[1] = arr[right];
                found = true;
                
            }else if(diff==closestDiff){
                if(Math.abs(arr[left]-arr[right])>Math.abs(result[0]-result[1])){
                    result[0] = arr[left];
                    result[1] = arr[right];
                }
            }
            if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        if(found){
            Arrays.sort(result);
            return Arrays.asList(result[0], result[1]);
        }else{
            return new ArrayList<>();
        }
        
    }
}