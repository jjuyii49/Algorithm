import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Queue<int[]> queue = new ArrayDeque<>();    // [서버 증설 시간, 개수]
        int now = 0;
        
        for(int t = 0; t < 24; t++) {
            while(!queue.isEmpty() && queue.peek()[0] + k <= t) {
                int[] current = queue.poll();
                
                now -= current[1];
            }
            
            if(players[t] == 0 || players[t] < m) continue;
            if(players[t] <= now * m) continue;
            
            int total = (int)Math.floor((double)players[t] / m);
            int need = total - now;
            
            if(need != 0) {
                queue.offer(new int[]{t, need});
                now = total;
                answer += need;
            }
        }
        
        return answer;
    }
}