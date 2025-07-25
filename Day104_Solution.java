class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] res = new int[n + 1];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<=n; i++){
            int val =(i==n)?0:arr[i];
            while(!stack.isEmpty() && val <= arr[stack.peek()]){
                int mid = stack.pop();
                int len = i-(stack.isEmpty()? -1 : stack.peek()) - 1 ;
                res[len] = Math.max(res[len], arr[mid]);
            }
            stack.push(i);
        }
        
        for(int i=n - 1; i>=1; i--){
            res[i] = Math.max(res[i], res[i + 1]);
    }
    ArrayList<Integer> result = new ArrayList<>();
    for(int i=1; i<=n; i++){
        result.add(res[i]);
    }
    return result;
    }
}