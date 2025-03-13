import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        boolean[] number = new boolean[10];
        List<String> XList = new ArrayList<>();
        Set<Integer> notations = new HashSet<>();
        
        for(String ex : expressions) {
            String[] str = ex.split(" ");
            
            int a = Integer.parseInt(str[0]);
            String op = str[1];
            int b = Integer.parseInt(str[2]);
            String sResult = str[4];
            
            number[a % 10] = true;
            number[b % 10] = true;
            
            if(sResult.equals("X")) {
                XList.add(ex);
                continue;
            }
            
            number[Integer.parseInt(sResult) % 10] = true;
        }
        
        for(String ex : expressions) {
            String[] str = ex.split(" ");
            
            int a = Integer.parseInt(str[0]);
            String op = str[1];
            int b = Integer.parseInt(str[2]);
            String sResult = str[4];
            
            if(sResult.equals("X")) continue;
            
            // 진법 찾기
            for(int n = 9; n >= 2; n--) {
                if(number[n]) break;
                
                int num = calc(a, b, n, op);
                
                if(!sResult.equals(num + "")) number[n] = true;
                else notations.add(n);
            }
        }
        
        String[] answer = new String[XList.size()];
        
        for(int i = 0; i < XList.size(); i++) {
            String[] str = XList.get(i).split(" ");
            
            int a = Integer.parseInt(str[0]);
            String op = str[1];
            int b = Integer.parseInt(str[2]);
            
            List<Integer> nums = new ArrayList<>();
            
            if(notations.isEmpty()) {
                for(int n = 9; n >= 2; n--) {
                    if(number[n]) break;

                    nums.add(calc(a, b, n, op));
                }
            } else {
                for(int n = 2; n < 10; n++) {
                    if(notations.contains(n)) {
                        if(number[n]) continue;

                        nums.add(calc(a, b, n, op));   
                    }
                }
            }
            
            boolean noAnswer = false;
            int num = nums.get(0);
            for(int j = 1; j < nums.size(); j++) {
                if(num != nums.get(j)) {
                    noAnswer = true;
                    break;
                }
            }
            
            if(noAnswer) answer[i] = str[0] + " " + str[1] + " " + str[2] + " = ?";
            else answer[i] = str[0] + " " + str[1] + " " + str[2] + " = " + num;
        }
        
        return answer;
    }
    
    private int calc(int a, int b, int n, String op) {
        int newA = (a / 10) * n + (a % 10);
        int newB = (b / 10) * n + (b % 10);

        int iResult = 0;
        if(op.equals("+")) iResult = newA + newB;
        else iResult = newA - newB;

        int temp = 0;
        int count = 1;
        while(iResult != 0) {
            temp += (iResult % n) * count;
            iResult = iResult / n;
            count *= 10;
        }
        
        return temp;
    }
}