import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        String str = storey + "";
        
        while(!str.equals("")) {
            int n = str.charAt(str.length() - 1) - '0';
            
            str = str.substring(0, str.length() - 1);
            
            // 자릿수가 5보다 작으면 -를 눌러 내려감
            if(n < 5) answer += n;
            else if(n == 5) { // 자릿수가 5이면 다음 자릿수를 비교하여 올림 내림 결정
                answer += n;
                if(!str.equals("") && str.charAt(str.length() - 1) -'0' >= 5) {
                    str = (Integer.parseInt(str) + 1) + "";
                }
            }
            else {  // 5보다 크면 +를 눌러 윗자리수로 올림
                answer += (10 - n);
                if(str.equals("")) str = "1";
                else str = (Integer.parseInt(str) + 1) + "";
            }
            
            System.out.println("n : " + n);
            System.out.println("str : " + str);
        }
        
        return answer;
    }
}