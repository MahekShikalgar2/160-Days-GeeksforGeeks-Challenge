class Solution {
    public int[] singleNum(int[] arr) {
        int xor = 0;
        
        for(int num : arr){
            xor ^= num;
        }
        int rightmostSetBit = xor & -xor;
        
        int num1 = 0, num2 = 0;
        for(int num : arr){
            if((num & rightmostSetBit) != 0){
                num1 ^= num;
            }else{
                num2 ^= num;
            }
            
        }
            int[] result = new int[2];
            result[0] = Math.min(num1, num2);
            result[1] = Math.max(num1, num2);
            return result;
        
    }
}