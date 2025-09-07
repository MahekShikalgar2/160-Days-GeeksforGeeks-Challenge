class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if(originalColor != newColor){
            dfs(image, sr, sc, originalColor, newColor);
        }
        return image;
    }
    private void dfs(int[][] image, int row, int col, int originalColor, int newColor){
        if(row<0 || row>=image.length || col<0 || col>=image[0].length || image[row][col] != originalColor){
            return;
        }
        image[row][col] = newColor;
        
        dfs(image, row - 1, col, originalColor, newColor);
        dfs(image, row + 1, col, originalColor, newColor);
        dfs(image, row, col - 1, originalColor, newColor);
        dfs(image, row, col  + 1, originalColor, newColor);
    }
}