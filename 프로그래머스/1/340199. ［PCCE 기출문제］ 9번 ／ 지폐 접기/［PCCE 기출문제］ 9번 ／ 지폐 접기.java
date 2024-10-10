import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int wb, ws;
        wb = Math.max(wallet[0], wallet[1]);
        ws = Math.min(wallet[0], wallet[1]);
        
        while(true) {
            int bb, bs;
            bb = Math.max(bill[0], bill[1]);
            bs = Math.min(bill[0], bill[1]);
            
            if(wb >= bb && ws >= bs) break;
            
            bill[0] = bb / 2;
            bill[1] = bs;
            answer++;
        }
        
        return answer;
    }
}