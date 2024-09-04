import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int length = balls.length;
        
        int[] answer = new int[length];
        
        int[][] direction = new int[length][4];   // 상하좌우
        for(int i = 0; i < length; i++) {
            Arrays.fill(direction[i], Integer.MAX_VALUE);
        }
        
        for(int i = 0; i < length; i++) {
            int x = balls[i][0];
            int y = balls[i][1];
            
            // 상
            if(!(x == startX && y > startY)) {
                direction[i][0] = Math.abs(x - startX) * Math.abs(x - startX) + 
                    ((n - y) + (n - startY)) * ((n - y) + (n - startY));
            }
            
            // 하
            if(!(x == startX && y < startY)) {
                direction[i][1] = Math.abs(x - startX) * Math.abs(x - startX) + 
                    (y + startY) * (y + startY);
            }
            
            // 좌
            if(!(x < startX && y == startY)) {
                direction[i][2] = Math.abs(y - startY) * Math.abs(y - startY) +
                    (x + startX) * (x + startX);
            }
            
            // 우
            if(!(x > startX && y == startY)) {
                direction[i][3] = Math.abs(y - startY) * Math.abs(y - startY) +
                    ((m - x) + (m - startX)) * ((m - x) + (m - startX));
            }
        }
        
        for(int i = 0; i < length; i++) {
            int min = direction[i][0];
            
            for(int j = 1; j < 4; j++) {
                min = Math.min(min, direction[i][j]);
            }
            
            answer[i] = min;
        }
        return answer;
    }
}