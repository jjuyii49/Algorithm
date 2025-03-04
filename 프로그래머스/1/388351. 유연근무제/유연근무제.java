import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int n = schedules.length;
        
        int[] timeLimit = new int[n];
        boolean[] gift = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            int time = schedules[i];
            int m = time / 100;
            int s = time % 100;
            
            s += 10;
            if(s >= 60) {
                m++;
                s -= 60;
            }
            
            time = m * 100 + s;
            timeLimit[i] = time;
            gift[i] = true;
        }
        
        for(int i = 0; i < n; i++) {
            int day = startday;
            
            for(int j = 0; j < 7; j++) {
                if(day == 6 || day == 7) {
                    day++;
                    continue;
                }
                
                if(day == 8) day %= 7;
                
                if(timelogs[i][j] > timeLimit[i]) {
                    gift[i] = false;
                    break;
                }
                
                day++;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(gift[i]) answer++;
        }
        
        return answer;
    }
}