class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str:arr){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(List<String> list:map.values()){
            result.add((ArrayList<String>) list);
        }
        return result;
        
    }
}
