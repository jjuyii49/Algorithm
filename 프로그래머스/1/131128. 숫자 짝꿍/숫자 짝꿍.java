import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int[] numX = new int[10];
        int[] numY = new int[10];
        
        for(int i = 0; i < X.length(); i++) {
            int n = X.charAt(i) - '0';
            numX[n]++;
        }
        
        for(int i = 0; i < Y.length(); i++) {
            int n = Y.charAt(i) - '0';
            numY[n]++;
        }
        
        for(int i = 9; i >= 0; i--) {
            if(numX[i] == 0 || numY[i] == 0) continue;
            
            int count = Math.min(numX[i], numY[i]);
            for(int j = 0; j < count; j++) {
                sb.append(i + "");
            }
        }
        
        answer = sb.toString();
        if(answer.equals("")) return "-1";
        if(answer.replaceAll("0", "").equals("")) return "0";
        
        return answer;
    }
}