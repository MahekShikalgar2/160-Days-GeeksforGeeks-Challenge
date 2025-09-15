class Solution {
    public int findDuplicate(int[] arr) {
       for(int i=0; i<arr.length; i++){
           int index = Math.abs(arr[i]);
           if(arr[index - 1]<0){
               return index;
           }
           arr[index - 1] *= -1;
       }
       return -1;
        
    }
}