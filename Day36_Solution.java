class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int[][] matrix){
           
            int n = matrix.length;
            int m = matrix[0].length;
            
        ArrayList<Integer> result = new ArrayList<>();
        int top = 0, bottom = n-1;
        int left = 0, right = m-1;
    
        
        while(top<= bottom && left<=right){
            for(int i=left; i<=right; i++)
            result.add(matrix[top][i]);
            top++;
            
            for(int i=top; i<=bottom; i++)
            result.add(matrix[i][right]);
            right--;
            
            if(top<=bottom){
                for(int i=right; i>=left; i--)
                result.add(matrix[bottom][i]);
                bottom--;
            }
            
            if(left<=right){
                for(int i=bottom; i>=top; i--)
                result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
        
    }
}
