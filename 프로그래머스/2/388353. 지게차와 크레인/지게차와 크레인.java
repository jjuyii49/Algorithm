import java.util.*;

class Solution {
    
    int n, m, answer;
    char[][] map;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    boolean[][] visited;
    
    public int solution(String[] storage, String[] requests) {
        answer = 0;
        
        n = storage.length;
        m = storage[0].length();
        
        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = storage[i].charAt(j);
            }
        }
        
        for(int r = 0; r < requests.length; r++) {
            int length = requests[r].length();
            
            char[][] tempMap = new char[n][m];
            for(int i = 0; i < n; i++) {
                tempMap[i] = Arrays.copyOfRange(map[i], 0, m);
            }
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == requests[r].charAt(0)) {
                        if(length > 1) map[i][j] = ' ';  // 크레인 사용
                        else check(i, j, requests[r].charAt(0), tempMap); // 지게차 사용
                    }
                }
            }
            
            if(length == 1) {
                for(int i = 0; i < n; i++) {
                    map[i] = Arrays.copyOfRange(tempMap[i], 0, m);
                }
            }
        }
        
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != ' ' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        
        return answer;
    }
    
    private void check(int r, int c, char rq, char[][] tempMap) {
        boolean[][] path = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[] {r, c});
        path[r][c] = true;
        
        boolean out = false;
        
        loop : while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    out = true;
                    break loop;
                }
                
                if(path[nr][nc]) continue;

                if(map[nr][nc] == ' ') {
                    queue.offer(new int[] {nr, nc});
                    path[nr][nc] = true;
                }
            }
        }
        
        if(out) tempMap[r][c] = ' ';
    }
    
    private void bfs(int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        answer++;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nc < 0 || nr >= n || nc >= c) continue;
                if(map[nr][nc] == ' ') continue;
                if(visited[nr][nc]) continue;
                
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
                answer++;
            }
        }
    }
}