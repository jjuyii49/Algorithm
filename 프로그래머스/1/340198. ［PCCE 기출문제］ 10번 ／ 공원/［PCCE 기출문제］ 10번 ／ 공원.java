import java.util.*;

class Solution {
    String[][] map;
    int n, m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    boolean[][] visited;
    
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        map = park;
        n = map.length;
        m = map[0].length;
        Arrays.sort(mats);
        
        for(int i = mats.length - 1; i >= 0; i--) {
            if(check(mats[i])) return mats[i];
        }
        
        return answer;
    }
    
    private boolean check(int size) {
        for(int i = 0; i <= n - size; i++) {
            for(int j = 0; j <= m - size; j++) {
                if(map[i][j].equals("-1")) {
                    if(bfs(i, j, size)) return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean bfs(int sr, int sc, int size) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        visited = new boolean[n][m];
        visited[sr][sc] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];
                
                if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) continue;
                if(nr < sr || nc < sc || nr >= sr + size || nc >= sc + size) continue;
                if(!map[nr][nc].equals("-1")) return false;
                if(visited[nr][nc]) continue;
                
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
        
        return true;
    }
}