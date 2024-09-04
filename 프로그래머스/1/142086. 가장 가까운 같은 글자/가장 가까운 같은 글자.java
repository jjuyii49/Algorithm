import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] alpha = new int[26];
        int length = s.length();
        
        int[] answer = new int[length];
        
        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            
            int index = c - 'a';
            if(alpha[index] == 0) answer[i] = -1;
            else answer[i] = i + 1 - alpha[index];
            
            alpha[index] = i + 1;
        }
        
        return answer;
    }
}