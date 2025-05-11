
class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        if(arr.length <= 1)
        return Arrays.asList(arr);
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        
        int[] current = arr[0];
        merged.add(current);
        
        for(int[] interval : arr){
            int currentEnd = current[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            
            if(nextStart <= currentEnd){
                current[1] = Math.max(currentEnd, nextEnd);
            }else{
                current = interval;
                merged.add(current);
            }
        }
        return merged;
        
    }
}