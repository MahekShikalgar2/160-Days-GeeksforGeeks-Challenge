class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
       int n = mat.length;
       int m = mat[0].length;
       
       int left = 0;
       int right = n*m-1;
       
       while(left<=right){
           int mid = left+(right-left)/2;
           int midValue = mat[mid/m][mid%m];
           
           if(midValue==x){
               return true;
           }else if(midValue < x){
               left=mid+1;
           }else{
               right=mid-1;
           }
       }
       return false;
        
    }
}
