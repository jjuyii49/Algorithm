import java.util.*;

class Solution {
    
    int n, m;
    boolean[][][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length();
        
        visited = new boolean[2][n][m];
        
        loop : for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maps[i].charAt(j) == 'S') {
                    answer = bfs(i, j, maps);
                    break loop;
                }
            }
        }
        
        return answer;
    }
    
    private int bfs(int r, int c, String[] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c, 0, 0});    // r, c, 레버 여부, time
        visited[0][r][c] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            int cr = current[0];
            int cc = current[1];
            int lever = current[2];
            int time = current[3];
            
            if(maps[cr].charAt(cc) == 'E' && lever == 1) return time;
            
            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                
                char next = maps[nr].charAt(nc);
                if(next == 'X') continue;
                
                if(next == 'L' && !visited[lever][nr][nc]) {
                    queue.offer(new int[] {nr, nc, 1, time + 1});
                    visited[lever][nr][nc] = true;
                    continue;
                }
                
                if(next == 'O' && !visited[lever][nr][nc]) {
                    queue.offer(new int[] {nr, nc, lever, time + 1});
                    visited[lever][nr][nc] = true;
                    continue;
                }
                
                if(next == 'E' && !visited[lever][nr][nc]) {
                    queue.offer(new int[] {nr, nc, lever, time + 1});
                    visited[lever][nr][nc] = true;
                    continue;
                }
                
                if(next == 'S' && !visited[lever][nr][nc]) {
                    queue.offer(new int[] {nr, nc, lever, time + 1});
                    visited[lever][nr][nc] = true;
                }
            }
        }
        
        return -1;
    }
}