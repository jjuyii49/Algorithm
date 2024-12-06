import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        
        List<Integer> frequencies = new ArrayList<>(map.values());
        frequencies.sort(Collections.reverseOrder());
        
        for(int f : frequencies) {
            k -= f;
            answer++;
            
            if(k <= 0) break;
        }
        
        return answer;
    }
}