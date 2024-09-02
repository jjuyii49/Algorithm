import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        int W = park.length;
        int H = park[0].length();
        
        int r = 0;
        int c = 0;
        
        loop : for(int i = 0; i < W; i++) {
            for(int j = 0; j < H; j++) {
                if(park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                    break loop;
                }
            }
        }
        
        loop2 : for(int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            
            int n = Integer.parseInt(route[1]);
            
            switch (route[0]) {
                case "N" :
                    for(int j = 1; j <= n; j++) {
                        int nr = r - j;
                        
                        if(nr < 0 || park[nr].charAt(c) == 'X') continue loop2;
                    }
                    
                    r -= n;
                    break;
                case "S" :
                    for(int j = 1; j <= n; j++) {
                        int nr = r + j;
                        
                        if(nr >= W || park[nr].charAt(c) == 'X') continue loop2;
                    }
                    
                    r += n;
                    break;
                case "W" :
                    for(int j = 1; j <= n; j++) {
                        int nc = c - j;
                        
                        if(nc < 0 || park[r].charAt(nc) == 'X') continue loop2;
                    }
                    
                    c -= n;
                    break;
                case "E" :
                    for(int j = 1; j <= n; j++) {
                        int nc = c + j;
                        
                        if(nc >= H || park[r].charAt(nc) == 'X') continue loop2;
                    }
                    
                    c += n;
                    break;
            }
        }
        
        answer = new int[] {r, c};
        
        return answer;
    }
}