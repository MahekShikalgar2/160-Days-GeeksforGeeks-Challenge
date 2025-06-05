
class Solution {

    int countPairs(int arr[], int target) {
        int left = 0;
        int right = arr.length-1;
        int count = 0;
        
        while(left<right){
            int sum = arr[left]+arr[right];
            
            if(sum==target){
                int x = arr[left];
                int leftCount = 0;
                while(left<=right && arr[left]==x){
                    leftCount++;
                    left++;
                }
                int y = arr[right];
                int rightCount = 0;
                while(left<=right && arr[right]==y){
                    rightCount++;
                    right--;
                }
                if(x==y){
                    count += (leftCount*(leftCount-1))/2;
                }else{
                    count += leftCount*rightCount;
                }
            }else if(sum<target){
                left++;
                
            }else{
                right--;
            }
        }
        return count;
    }
}
