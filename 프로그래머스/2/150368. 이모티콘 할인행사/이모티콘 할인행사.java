import java.util.*;

class Solution {
    
    int[] sales = {40, 30, 20, 10};
    int maxUser, maxPrice;
    int n, m;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        n = users.length;
        m = emoticons.length;
        
        maxUser = Integer.MIN_VALUE;
        maxPrice = Integer.MIN_VALUE;
        
        comb(0, emoticons, new ArrayList<>(), users);
        
        answer = new int[] {maxUser, maxPrice};
        return answer;
    }
    
    private void comb(int count, int[] emoticons, ArrayList<Integer> selected, int[][] users) {
        if(count == m) {
            int plus = 0, price = 0;
            
            for(int i = 0; i < n; i++) {
                int temp = 0;
                for(int j = 0; j < m; j++) {
                    // 기준 할인율 이상인 경우 구매 예상 금액 계산
                    if(selected.get(j) >= users[i][0]) {
                        temp += emoticons[j] * (100 - selected.get(j)) / 100;
                    }
                }
                
                // 예상 금액이 구매 기준 이상이면 플러스 가입
                if(temp >= users[i][1]) plus++;
                else price += temp; // 아니면 이모티콘 구매
            }
            
            if(plus > maxUser) {
                maxUser = plus;
                maxPrice = price;
            } else if (plus == maxUser) {
                maxPrice = Math.max(maxPrice, price);
            }
            
            return;
        }

        for(int i = 0; i < 4; i++) {
            selected.add(sales[i]);
            comb(count + 1, emoticons, selected, users);
            selected.remove(selected.size() - 1);
        }
    }
}