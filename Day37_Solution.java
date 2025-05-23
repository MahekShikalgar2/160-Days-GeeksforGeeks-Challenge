
class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int matrix[][]) {
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int j=0; j<n; j++){
            int top = 0;
            int bottom = n-1;
            while(top<bottom){
                int temp = matrix[top][j];
                matrix[top][j] = matrix[bottom][j];
                matrix[bottom][j] = temp;
                top++;
                bottom--;
            }
        }
    }
}