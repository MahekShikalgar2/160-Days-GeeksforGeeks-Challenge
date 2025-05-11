class Solution {
     void reverse(int[] arr, int start, int end) 
     {
        
        while(start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
     void rotateArr(int[] arr, int d)
     {
         int n = arr.length;
         d = d % n;
         if(d == 0) return;
         
         reverse(arr, 0, d - 1);
         reverse(arr, d, n - 1);
         reverse(arr, 0, n - 1);
    }
    public static void main(String[] args)
    {
        Solution obj = new Solution();
        int[] arr ={1, 2, 3, 4, 5};
        int d = 2;
        
        
        obj.rotateArr(arr, d);
        System.out.print("Array after left rotation: ");
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}