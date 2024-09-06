import java.util.*;

class Solution {
    
    int totalDice;
    int[][] dices;
    List<int[]> combList;
    
    public int[] solution(int[][] dice) {
        int[] answer = {};
        
        totalDice = dice.length;
        dices = dice;
        combList = new ArrayList<>();
        
        comb(1, 0, new int[totalDice / 2]); // A 주사위 뽑기
        
        int max = Integer.MIN_VALUE;
        for(int[] a : combList) {
            // A 주사위 합 구하기
            List<Integer> aSumList = new ArrayList<>();
            getScores(0, 0, a, aSumList);
            
            // B 주사위 합 구하기
            int[] b = getBComb(a);
            List<Integer> bSumList = new ArrayList<>();
            getScores(0, 0, b, bSumList);
            
            // 정렬
            Collections.sort(aSumList);
            Collections.sort(bSumList);
            
            int win = getWinCountOfA(aSumList, bSumList);
            
            if(max < win) {
                max = win;
                answer = a;
            }
        }
        
        return answer;
    }
    
    private void comb(int index, int count, int[] selected) {
        if(count == totalDice / 2) {
            combList.add(selected.clone());
            return;
        }
        
        for(int i = index; i < totalDice + 1; i++) {
            selected[count] = i;
            comb(i + 1, count + 1, selected);
        }
    }
    
    private void getScores(int count, int sum, int[] comb, List<Integer> aSumList) {
        if(count == totalDice / 2) {
            aSumList.add(sum);
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            getScores(count + 1, sum + dices[comb[count] - 1][i], comb, aSumList);
        }
    }
    
    private int[] getBComb(int[] a) {
        boolean[] selected = new boolean[totalDice + 1];
        
        for(int i = 0; i < a.length; i++) {
            selected[a[i]] = true;
        }
        
        int[] b = new int[totalDice / 2];
        for(int i = 1, index = 0; i < totalDice + 1; i++) {
            if(!selected[i]) b[index++] = i;
        }
        
        return b;
    }
    
    private int getWinCountOfA(List<Integer> aList, List<Integer> bList) {
        int count = 0;
        
        for(int i = 0; i < aList.size(); i++) {
            int a = aList.get(i);
            int left = 0;
            int right = bList.size() - 1;
            
            while(left <= right) {
                int mid = (left + right) / 2;
                
                if(a <= bList.get(mid)) right = mid - 1;
                else left = mid + 1;
            }
            
            count += right;
        }
        
        return count;
    }
}