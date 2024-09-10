import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        int[] dx = {2, 3};
        
        boolean[] visited = new boolean[1000001];
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, 0});
        visited[x] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            if(current[0] == y) return current[1];
            
            for(int i = 0; i < 3; i++) { 
                int nx = i == 2? current[0] + n : current[0] * dx[i];
                
                if(nx < 1 || nx > 1000000) continue;
                if(visited[nx]) continue;
                
                queue.offer(new int[] {nx, current[1] + 1});
                visited[nx] = true;
            }
        }
        
        return answer;
    }
}