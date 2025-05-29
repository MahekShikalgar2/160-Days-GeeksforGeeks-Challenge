class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        int maxLength = 0;
        for(int num:set){
            if(!set.contains(num-1)){
                int currentNum = num;
                int currentLength = 1;
                
                while(set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentLength += 1;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
        
    }
}