import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < ingredient.length; i++) {
            if(stack.size() < 4) {
                stack.push(ingredient[i]);
            }
            else {
                int index = stack.size() - 1;
                
                if(stack.get(index) == 1 && stack.get(index - 1) == 3
                  && stack.get(index - 2) == 2 && stack.get(index - 3) == 1) {
                    for(int j = 0; j < 4; j++) {
                        stack.pop();
                    }
                    answer++;
                }
                
                stack.push(ingredient[i]);
            }
        }
        
        while(stack.size() >= 4) {
            int index = stack.size() - 1;
            
            if(stack.get(index) == 1 && stack.get(index - 1) == 3
              && stack.get(index - 2) == 2 && stack.get(index - 3) == 1) {
                for(int j = 0; j < 4; j++) {
                    stack.pop();
                }
                answer++;
            } else break;
        }
        
        return answer;
    }
}