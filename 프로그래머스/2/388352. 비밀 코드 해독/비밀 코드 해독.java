import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        comb(1, 0, n, q, ans, new ArrayList<Integer>());
        
        return answer;
    }
    
    private void comb(int idx, int count, int n, int[][] q, int[] ans, List<Integer> list) {
        if(count == 5) {
            if(check(list, q, ans)) answer++;
            
            return;
        }
        
        for(int i = idx; i <= n; i++) {
            list.add(i);
            comb(i + 1, count + 1, n, q, ans, list);
            list.remove(list.size() - 1);
        }
    }
    
    private boolean check(List<Integer> list, int[][] q, int[] ans) {
        for(int i = 0; i < q.length; i++) {
            int cnt = 0;
            
            for(int j = 0; j < 5; j++) {
                if(list.contains(q[i][j])) cnt++;
            }
            
            if(cnt != ans[i]) return false;
        }
        
        return true;
    }
}