import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < score.length; i++) {
            pq.offer(score[i]);
            
            if(i >= k) pq.poll();
            
            answer[i] = pq.peek();
        }
        
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
}