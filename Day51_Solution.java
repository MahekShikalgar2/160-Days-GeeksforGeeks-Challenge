class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
        for(int i=0; i<n-2; i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum = arr[i] + arr[j] + arr[k];
                
                if(sum<target){
                    j++;
                }else if(sum>target){
                    k--;
                }else{
                    int x = arr[j];
                    int cx = 0;
                    while(j<=k && arr[j]==x){
                        cx++;
                        j++;
                    }
                    int y = arr[k];
                    int cy = 0;
                    while(j<=k && arr[k]==y){
                        cy++;
                        k--;
                    }
                    if(x==y){
                        count += cx*(cx-1)/2;
                    }else{
                        count += cx*cy;
                    }
                }
            }
        }
            return count;
        }
    }
    
