import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        
        for(int i = 2; i < number + 1; i++) {
            int count = 0;
            
            boolean check = false;
            for(int j = 1; Math.pow(j, 2) <= i; j++) {
                if(Math.pow(j, 2) == i) check = true;
                if(i % j == 0) count++;
            }
            
            count *= 2;
            
            if(check) count--;
            
            if(count > limit) count = power;
            answer += count;
        }
        
        return answer;
    }
}