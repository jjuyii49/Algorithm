import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] num = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < num.length; i++) {
            max = Math.max(max, Integer.parseInt(num[i]));
            min = Math.min(min, Integer.parseInt(num[i]));
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}