
class Solution {
public int firstOccurrence(int[] arr, int target)
    {
        int low = 0, high = arr.length - 1, result = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                result = mid;
                high = mid-1;
        } else if (arr[mid]<target){
            low = mid+1;
        } else{
            high = mid-1;
        }
    }
    return result;
}

public int lastOccurrence(int[] arr, int target){
    int low = 0, high = arr.length - 1, result = -1;
    
    while(low<=high){
        int mid = low+(high-low)/2;
        if(arr[mid]==target){
            result = mid;
            low = mid+1;
        }else if(arr[mid]<target){
            low = mid+1;
        }else{
            high = mid-1;
        }
    }
    return result;
}
public int countFreq(int[] arr, int target){
    
    int first = firstOccurrence(arr, target);
    
    if(first == -1) return 0;
    int last = lastOccurrence(arr, target);
    return last - first + 1;
   }
}

