class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
       int n = nums.length;
       int count1 = 0, count2 = 0;
       Integer candidate1 = null, candidate2 = null;
       
       for(int num : nums){
           if(candidate1!=null && candidate1 == num){
               count1++;
           }else if(candidate2!=null && candidate2 == num){
               count2++;
           }else if(count1 == 0){
               candidate1 = num;
               count1 = 1;
           }else if(count2 == 0){
               candidate2 = num;
               count2 = 1;
           }else{
               count1--;
               count2--;
           }
       }
       count1 = 0;
       count2 = 0;
       
       for(int num : nums){
           if(candidate1 != null && candidate1 == num)count1++;
           if(candidate2 != null && candidate2 == num)count2++;
       }
       List<Integer> result = new ArrayList<>();
       
       if(count1 > n/3)
        result.add(candidate1);
        
        if(candidate2 != null && !
        candidate2.equals(candidate1) && count2 > n/3)
        result.add(candidate2);
        
        Collections.sort(result);
        
        return result;
    }
}
