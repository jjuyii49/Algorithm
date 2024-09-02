import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int[] map = new int[n + 1];
        
        for(int i = 0; i < section.length; i++) {
            map[section[i]] = 1;
        }
        
        for(int i = 1; i < n + 1; i++) {
            if(map[i] == 1) {
                answer++;
                for(int j = i; j < i + m; j++) {
                    if(j >= n + 1) break;
                    map[j] = 0;
                }
            }
        }
        
        return answer;
    }
}