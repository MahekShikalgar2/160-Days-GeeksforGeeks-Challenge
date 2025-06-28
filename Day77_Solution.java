class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
       ArrayList<ArrayList<Integer>> result = new ArrayList<>();
       int[] board = new int[n];
       solveNQueensUtil(n, 0, board, result);
       return result;
        
    }
    private void solveNQueensUtil(int n, int col, int[] board, ArrayList<ArrayList<Integer>> result){
        if(col == n){
            ArrayList<Integer> solution = new ArrayList<>();
            for(int i=0; i<n; i++){
                solution.add(board[i] + 1);
            }
            result.add(solution);
            return;
        }
        for(int row=0; row<n; row++){
            if(isSafe(board, row, col))
            {
                board[col] = row;
                solveNQueensUtil(n, col + 1, board, result);
            }
        }
    }
    private boolean isSafe(int[] board, int row, int col){
        for(int i=0; i<col; i++){
            if(board[i] == row || board[i] - i == row - col || board[i] + i == row + col){
                return false;
            }
        }
        return true;
    }
}