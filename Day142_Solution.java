class Solution {
    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
        for(int i=0; i<n; i++){
            for(int j=0;
             j<m; j++){
                 if(grid[i][j] == 'L'){
                     dfs(grid, i, j, directions);
                     count++;
                 }
             }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int[][] directions){
        int n = grid.length;
        int m = grid[0].length;
        grid[i][j] = 'W';
        
        for(int[] direction : directions){
            int x = i + direction[0];
            int y = j + direction[1];
            
            if(x>=0 && x<n && y>=0 && y<m && grid[x][y] == 'L'){
                dfs(grid, x, y, directions);
            }
        }
    }
}