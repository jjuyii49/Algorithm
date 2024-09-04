import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long num = Long.parseLong(p);
        int tLength = t.length();
        int pLength = p.length();
        
        for(int i = 0; i < tLength - pLength + 1; i++) {
            String temp = t.substring(i, i + pLength);
            
            long numT = Long.parseLong(temp);

            if(numT <= num) answer++;
        }
        
        return answer;
    }
}