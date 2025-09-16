class Solution {
    int missingNum(int arr[]) {
        long n = arr.length + 1;
        long totalSum = n * (n + 1)/2;
        long arrSum = 0;
        for(int num : arr){
            arrSum += num;
        }
        return (int) (totalSum - arrSum);
        
    }
}