import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col - 1] == o2[col - 1]) return -(o1[0] - o2[0]);
            
            return o1[col - 1] - o2[col - 1];
        });
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = row_begin - 1; i <= row_end - 1; i++) {
            int mod = 0;
            
            for(int j = 0; j < data[i].length; j++) {
                mod += data[i][j] % (i + 1);
            }
            
            list.add(mod);
        }
        
        answer = list.get(0);
        
        for(int i = 1; i < list.size(); i++) {
            answer = answer ^ list.get(i);
        }
         
        return answer;
    }
}