class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long count1 = 0;
        long count2 = 0;

        for(int i = 1; i < r1; i++) {
            double maxY = Math.sqrt(Math.pow((double)r1, 2) - Math.pow((double)i, 2));
            if(maxY != (int) maxY) count1 += (int) maxY;
            else count1 += (int) maxY - 1;
        }

        for(int i = 1; i < r2; i++) {
            double maxY = Math.sqrt(Math.pow((double)r2, 2) - Math.pow((double)i, 2));
            count2 += (int) maxY;
        }

        answer = (count2 - count1) * 4 + (r2 - r1 + 1) * 4;
        
        return answer;
    }
}