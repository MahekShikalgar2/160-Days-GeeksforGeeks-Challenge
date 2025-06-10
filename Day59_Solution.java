class Solution {
    public long maxWater(int arr[]) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        long water = 0;
        int maxLeft = 0;
        int maxRight = 0;
        
        while(left <= right) {
                if(arr[left] < arr[right]) {
                    if(arr[left] >= maxLeft)
                    {
                        maxLeft = arr[left];
                    } else{
                    water += maxLeft - arr[left];
                    }
            left++;
        } else{
            if(arr[right]>=maxRight)
            {
                maxRight = arr[right];
            }  else{
                water += maxRight - arr[right];
            }
            right--;
        }
    }
        return water;
    }
}
