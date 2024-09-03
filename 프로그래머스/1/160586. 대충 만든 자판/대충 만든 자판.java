import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        PriorityQueue<Integer>[] alpha = new PriorityQueue[26];
        
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                int index = keymap[i].charAt(j) - 'A';
                
                if(alpha[index] == null) alpha[index] = new PriorityQueue<Integer>();
                alpha[index].offer(j + 1);
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            int sum = 0;
            for(int j = 0; j < targets[i].length(); j++) {
                int index = targets[i].charAt(j) - 'A';
                
                if(alpha[index] == null) {
                    sum = -1;
                    break;
                }
                else sum += alpha[index].peek();
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}