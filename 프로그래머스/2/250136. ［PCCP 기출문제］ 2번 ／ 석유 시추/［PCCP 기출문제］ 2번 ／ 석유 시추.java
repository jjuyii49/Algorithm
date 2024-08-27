import java.util.*;

class Solution {
    
    int n, m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    ArrayList<Integer> oilList = new ArrayList<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;

        int number = 2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1) bfs(i, j, land, number++);
            }
        }
        
        for(int j = 0; j < m; j++) {
            boolean[] check = new boolean[oilList.size()];
            int sum = 0;
            for(int i = 0; i < n; i++) {
                int num = land[i][j] - 2;
                if(num >= 0 && !check[num]) {
                    sum += oilList.get(num);
                    check[num] = true;
                }
            }
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    void bfs(int r, int c, int[][] land, int number) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c});
        land[r][c] = number;

        int count = 1;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if(land[nr][nc] != 1) continue;

                queue.offer(new int[] {nr, nc});
                land[nr][nc] = number;
                count++;
            }
        }

        oilList.add(count);
    }
}