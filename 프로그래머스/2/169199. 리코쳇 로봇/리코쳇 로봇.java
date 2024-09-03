import java.util.*;

class Solution {
    
    int n, m;
    int[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        int answer = 0;
        
        n = board.length;
        m = board[0].length();
        
        visited = new int[n][m];
        
        loop : for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i].charAt(j) == 'R') {
                    answer = bfs(i, j, board);
                    break loop;
                }
            }
        }
        
        return answer;
    }
    
    private int bfs(int r, int c, String[] board) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = 1;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            if(board[current[0]].charAt(current[1]) == 'G') return visited[current[0]][current[1]] - 1;
            
            for(int i = 0; i < 4; i++) {
                int count = 1;
                
                while(true) {
                    int nr = current[0] + dr[i] * count;
                    int nc = current[1] + dc[i] * count;

                    if(nr < 0 || nc < 0 || nr >= n || nc >= m) break;
                    if(board[nr].charAt(nc) == 'D') break;
                    
                    count++;
                }
                
                count--;
                int nr = current[0] + dr[i] * count;
                int nc = current[1] + dc[i] * count;
                
                if(visited[nr][nc] > 0) continue;
                
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = visited[current[0]][current[1]] + 1;
            }
        }
        
        return -1;
    }
}