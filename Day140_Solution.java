class Solution {
    public int orangesRotting(int[][] mat) {
      int n = mat.length;
      int m = mat[0].length;
      Queue<int[]> queue = new LinkedList<>();
      int freshCount = 0;
      int time = 0;
      
      for(int i=0; i<n; i++){
          for(int j=0; j<m; j++){
              if(mat[i][j] == 2){
                  queue.add(new int[]{i, j});
              }else if(mat[i][j] == 1){
                      freshCount++;
                  }
              }
          }
          
          int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
          
          while(!queue.isEmpty() && freshCount>0){
              int size = queue.size();
              for(int k=0; k<size; k++){
                  int[] current = queue.poll();
                  for(int[] direction : directions){
                      int x = current[0] + direction[0];
                      int y = current[1] + direction[1];
                      
                      
                      
                      if(x>=0 && x<n && y>=0 && y<m && mat[x][y] == 1){
                          mat[x][y] = 2;
                          queue.add(new int[] {x, y});
                          freshCount--;
                      }
                  }
              }
              time++;
          }
          
          return freshCount == 0 ? time : -1;
    }
}