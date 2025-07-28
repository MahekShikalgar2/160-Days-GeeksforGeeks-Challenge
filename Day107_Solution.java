class Solution {
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                k=k*10+c-'0';
            }else if(c == '['){
                countStack.push(k);
                stringStack.push(currentString.toString());
                currentString = new StringBuilder();
                k = 0;
            }else if(c == ']'){
                int count = countStack.pop();
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for(int i=0; i<count; i++){
                    temp.append(currentString);
                }
                currentString = temp;
            }else{
                currentString.append(c);
            }
        }
        return currentString.toString();
        
    }
}