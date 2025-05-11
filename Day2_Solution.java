class Solution {
    
    void pushZerosToEnd(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j++] = arr[i];
            }
        }
        while (j < arr.length) {
            arr[j++] = 0;
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr = {3, 0, 5, 0, 4};

        obj.pushZerosToEnd(arr);

       
        System.out.print("Modified array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
