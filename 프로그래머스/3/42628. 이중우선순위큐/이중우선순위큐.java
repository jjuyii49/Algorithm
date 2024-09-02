import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> pQueueLow = new PriorityQueue<>();
        PriorityQueue<Integer> pQueueHigh = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
            String[] input = operations[i].split(" ");
            
            int num = Integer.parseInt(input[1]);
            
            switch (input[0]) {
                case "I" -> {
                    pQueueLow.offer(num);
                    pQueueHigh.offer(num);
                }
                case "D" -> {
                    if(num == 1) {
                        if(!pQueueHigh.isEmpty()) pQueueLow.remove(pQueueHigh.poll());
                    }
                    else {
                        if(!pQueueLow.isEmpty()) pQueueHigh.remove(pQueueLow.poll());
                    }
                }
            }
        }
        
        if(pQueueHigh.isEmpty() && pQueueLow.isEmpty()) {
            answer = new int[] {0, 0};
        } else {
            answer = new int[] {pQueueHigh.peek(), pQueueLow.peek()};
        }
        
        return answer;
    }
}