import java.util.*;

class Solution {
    
    int n, m;
    boolean[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        n = maps.length;
        m = maps[0].length();
        
        visited = new boolean[n][m];
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    list.add(bfs(i, j, maps));
                }
            }
        }
        
        if(list.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    private int bfs(int r, int c, String[] maps) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        
        int count = maps[r].charAt(c) - '0';
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                
                char ch = maps[nr].charAt(nc);
                if(ch == 'X' || visited[nr][nc]) continue;
                
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
                count += ch - '0';
            }
        }
        
        return count;
    }
}