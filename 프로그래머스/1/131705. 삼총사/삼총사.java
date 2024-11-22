class Solution {
    int answer;
    public int solution(int[] number) {
        answer = 0;
        
        comb(0, 0, 0, number);
        return answer;
    }
    
    private void comb(int index, int count, int sum, int[] number) {
        if(count == 3) {
            if(sum == 0) {
                answer++;
            }
            
            return;
        }
        
        for(int i = index; i < number.length; i++) {
            comb(i + 1, count + 1, sum + number[i], number);
        }
    }
}