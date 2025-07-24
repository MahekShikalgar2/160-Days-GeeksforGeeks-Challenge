class Solution {
    public static int getMaxArea(int arr[]) {
        int n = arr.length;
        int[] nsr = new int[n];
        int[] nsl = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsr[i] = n;
            }else{
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = stack.peek();
            }
            stack.push(i);
        }
        int maxArea = 0;
        for(int i=0; i<n; i++){
            maxArea = Math.max(maxArea, arr[i]*(nsr[i]-nsl[i]-1));
        }
        return maxArea;
    }
}
