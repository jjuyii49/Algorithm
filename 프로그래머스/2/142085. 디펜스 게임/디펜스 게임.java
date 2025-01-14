import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
    
        // 우선순위 큐를 사용해 가장 많은 적을 찾는다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        
        for(int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            sum += enemy[i];
            
            // 현재 라운드까지의 모든 적이 병사보다 많은 경우 무적권을 사용
            if(sum > n) {
                if(k > 0) {
                    sum -= pq.poll();
                    k--;
                } else {    // 무적권이 없는 경우
                    return i;
                }
            }
        }
        
        return answer;
    }
}