class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        
        for(int num:a){
            setA.add(num);
        }
        for(int num:b){
            if(setA.contains(num)){
                intersection.add(num);
            }
        }
        ArrayList<Integer> result = new ArrayList();
        for(int num:intersection){
            result.add(num);
        }
        Collections.sort(result);
        return result;
        
    }
}