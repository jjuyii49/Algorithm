import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        list.add(-1);
        stack.push(numbers[numbers.length - 1]);
        
        for(int i = numbers.length - 2; i >= 0; i--) {
            while(!stack.isEmpty()) {
                if(stack.peek() <= numbers[i]) {
                    stack.pop();
                    if(stack.isEmpty()) {
                        list.add(-1);
                        stack.push(numbers[i]);
                        break;
                    } else continue;
                } else {
                    list.add(stack.peek());
                    stack.push(numbers[i]);
                    break;
                }
            }
        }
        
        answer = new int[list.size()];
        for(int i = 0, index = list.size() - 1; i < list.size(); i++, index--) {
            answer[i] = list.get(index);
        }
        
        return answer;
    }
}