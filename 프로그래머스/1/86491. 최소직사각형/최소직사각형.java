import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int num = sizes.length;
        int w = Integer.MIN_VALUE;
        int h = Integer.MIN_VALUE;
        
        for(int i = 0; i < num; i++) {
            if(sizes[i][0] >= sizes[i][1]) {
                w = Math.max(sizes[i][0], w);
                h = Math.max(sizes[i][1], h);
            } else {
                w = Math.max(sizes[i][1], w);
                h = Math.max(sizes[i][0], h);
            }
        }
        
        answer = w * h;
        return answer;
    }
}