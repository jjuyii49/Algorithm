import java.util.*;

class Solution {
    
    long answer;
    public long solution(int[] weights) {
        answer = 0;
        
        Arrays.sort(weights);
        
        Map<Double, Integer> map = new HashMap<>();
        
        for(int a : weights) {
            if(map.containsKey((double)a)) answer += map.get((double)a);
            if(map.containsKey((double)a * 2 / 3)) answer += map.get((double)a * 2 / 3);
            if(map.containsKey((double)a * 2 / 4)) answer += map.get((double)a * 2 / 4);
            if(map.containsKey((double)a * 3 / 4)) answer += map.get((double)a * 3 / 4);
            
            if(map.containsKey((double)a)) {
                map.replace((double)a, map.get((double)a) + 1);
            } else map.put((double)a, 1);
        }

        return answer;
    }
}