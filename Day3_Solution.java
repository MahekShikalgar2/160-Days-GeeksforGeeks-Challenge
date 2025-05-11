class Solution {
    public void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr = {1, 4, 3, 2, 6, 5}; 
        obj.reverseArray(arr);

        System.out.print("Reversed array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
