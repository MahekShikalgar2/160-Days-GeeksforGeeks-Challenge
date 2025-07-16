class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = arr.length - 1; k > 0; i-- , k--) {
        list.add(arr[i]);
        
    }
        return list;
        
    }
}
