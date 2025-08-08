class Solution {
    static int minCostClimbingStairs(int[] cost) {
       int n = cost.length;
       int a = cost[0], b = cost[1];
       for(int i=2; i<n; i++){
           int temp = Math.min(a, b) + cost[i];
           a = b;
           b = temp;
       }
       return Math.min(a, b);
        
    }
}