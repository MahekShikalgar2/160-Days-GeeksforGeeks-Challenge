class Solution {
    public int evaluate(String[] arr) {
       Stack<Integer> stack = new Stack<>();
       for(String token : arr){
           if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
               int operand2 = stack.pop();
               int operand1 = stack.pop();
               int result = calculate(operand1, operand2, token);
               stack.push(result);
           }else{
               stack.push(Integer.parseInt(token));
           }
       }
       return stack.pop();
        
    }
    private int calculate(int operand1, int operand2, String operator){
        switch(operator){
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
            throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }
}