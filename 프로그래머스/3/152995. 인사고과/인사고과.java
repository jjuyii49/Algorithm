import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] myScore = scores[0];
        int mySum = myScore[0] + myScore[1];
        
        int answer = 1;
        
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            
            return -(o1[0] - o2[0]);
        });
        
        int max = 0;
        
        for(int[] score : scores) {
            if(score[1] < max) {
                if(score[0] == myScore[0] && score[1] == myScore[1]) return -1;
                continue;
            }
            
            max = score[1];
            
            if(score[0] + score[1] > mySum) answer++;
        }
        
        return answer;
    }
}