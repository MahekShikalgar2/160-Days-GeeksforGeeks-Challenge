class Solution {
    int getSecondLargest(int[] arr){
        int n = arr.length;
        if (n < 2)
            return -1;
        
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for (int num : arr){
            if(num > first){
                second = first;
                first = num;
            }
            else if (num > second && num != first){
                second = num;
            }
        }
        return (second == Integer.MIN_VALUE) ? -1 : second;
        
    }
    public static void main(String[] args){
        Solution obj = new Solution();
        
        int[] arr1 = {12,35,1,10,34,1};
        int[] arr2 = {10,5,10};
        int[] arr3 = {10,10,10};
        
        System.out.println("Second Largest in arr1: " + obj.getSecondLargest(arr1));
        System.out.println("Second Largest in arr2: " + obj.getSecondLargest(arr2));
        System.out.println("Second Largest in arr3: " + obj.getSecondLargest(arr3));
    }
}