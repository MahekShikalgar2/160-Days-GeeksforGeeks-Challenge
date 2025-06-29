class Solution {
    static void solveSudoku(int[][] mat) {
        solve(mat);
        
    }
    static boolean solve(int[][] mat){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(mat[i][j] == 0){
                    for(int num=1; num<=9; num++){
                        if(isValid(mat, i, j, num)){
                            mat[i][j] = num;
                            if(solve(mat)){
                                return true;
                            }
                            mat[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isValid(int[][] mat, int row, int col, int num){
        for(int i=0; i<9; i++){
            if(mat[row][i] == num){
                return false;
            }
        }
        for(int i=0; i<9; i++){
            if(mat[i][col] == num){
                return false;
            }
        }
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(mat[boxRow + i] [boxCol + j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}