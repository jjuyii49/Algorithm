import java.util.*;

class Solution {
    
    List<Integer> list;
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        list = new ArrayList<>();
        list.add(k);
        number(k);
        
        int n = list.size();
        double[] areas = new double[n - 1];
        for(int i = 0, j = 0; i < n - 1; i++, j++) {
            areas[j] = (list.get(i) + list.get(i + 1)) / 2.0;
        }
        
        double[] sum = new double[n];
        for(int i = 0, j = 1; i < n - 1; i++, j++) {
            sum[j] = sum[j - 1] + areas[i];
        }
        
        for(int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = ranges[i][1] + n - 1;
            
            if(a <= b) answer[i] = sum[b] - sum[a];
            else answer[i] = -1.0;
        }
        
        return answer;
    }
    
    private void number(int k) {
        if(k % 2 == 0) k = k / 2;
        else k = k * 3 + 1;
        
        list.add(k);
        if(k == 1) return;
        
        number(k);
    }
}