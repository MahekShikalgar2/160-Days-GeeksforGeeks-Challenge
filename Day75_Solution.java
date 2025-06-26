class Solution {
    public ArrayList<String> findPermutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> result = new ArrayList<>();
        boolean[] visited = new boolean[chars.length];
        backtrack(result, new StringBuilder(), chars, visited);
        return result;
    }
    private void backtrack(List<String> result, StringBuilder temp, char[] chars, boolean[] visited){
        if(temp.length() == chars.length){
            result.add(temp.toString());
            return;
        }
        for(int i=0; i<chars.length; i++){
            if(visited[i] || (i>0 && chars[i] == chars[i - 1] && !visited[i - 1])){
                continue;
            }
            visited[i] = true;
            temp.append(chars[i]);
            backtrack(result, temp, chars, visited);
            temp.deleteCharAt(temp.length() -1);
            visited[i] = false;
        }
    }
}