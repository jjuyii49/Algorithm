import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        answer = new int[] {minX, minY, maxX + 1, maxY + 1};        
        
        return answer;
    }
}