import java.util.*;

class Solution {
    
    int count;
    int[][] copyMap;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        int[][] map = new int[n + 1][n + 1];
        
        for(int i = 1; i < n + 1; i++) {
            map[i][i] = 1;
        }
        
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            map[a][b] = map[b][a] = 1;
        }
        
        for(int w = 0; w < wires.length; w++) {
            copyMap = new int[n + 1][n + 1];
            visited = new boolean[n + 1];
            
            for(int i = 0; i < n + 1; i++) {
                copyMap[i] = Arrays.copyOf(map[i], n + 1);
            }
            
            int a = wires[w][0];
            int b = wires[w][1];
            
            copyMap[a][b] = copyMap[b][a] = 0;
            
            loop : for(int i = 1; i < n + 1; i++) {
                if(visited[i]) continue;
                count = 0;
                
                for(int j = 1; j < n + 1; j++) {
                    if(copyMap[i][j] == 1 && !visited[j]) {
                        dfs(n, j);
                        answer = Math.min(answer, Math.abs(n - count - count));
                        break loop;
                    }
                }
            }
        }
        
        return answer;
    }
    
    private void dfs(int n, int a) {
        for(int i = 1; i < n + 1; i++) {
            if(copyMap[a][i] == 1 && !visited[i]) {
                count++;
                visited[i] = true;
                dfs(n, i);
            }
        }
    }
}