import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int m = (int)Math.round(n / w + 0.5);
        
        int[][] map = new int[m][w];
        int box = 1;
        int x = 0, y = 0;
        boolean goLeft = false;
        
        loop : for(int i  = m - 1; i >= 0; i--) {
            if(goLeft) {
                for(int j = w - 1; j >= 0; j--) {
                    if(box > n) break loop;
                    
                    if(box == num) {
                        x = j;
                        y = i;
                    }

                    map[i][j] = box++;
                }
                
                goLeft = false;
            } else {
                for(int j = 0; j < w; j++) {
                    if(box > n) break loop;
                    
                    if(box == num) {
                        x = j;
                        y = i;
                    }

                    map[i][j] = box++;
                }
                
                goLeft = true;
            }
        }
        
        for(int i = 0; i <= y; i++) {
            if(map[i][x] == 0) continue;
            
            answer++;
            
            if(map[i][x] == num) break;
        }
        
        return answer;
    }
}