class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        String temp = "";
        for(int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            
            for(int j = 0; j < count; j++) {
                temp += i + "";
            }
        }
        
        answer = temp + "0";
        for(int i = temp.length() - 1; i >= 0; i--) {
            answer += temp.charAt(i) + "";
        }
        
        return answer;
    }
}