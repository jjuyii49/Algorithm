class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int length = s.length();
        int index = 0;
        int num1 = 1, num2 = 0;
        
        if(length == 1) return 1;
        
        for(int i = 1; i < length; i++) {
            char first = s.charAt(index);
            System.out.println("first : " + first);
            
            if(s.charAt(i) == first) {
                System.out.println("같음");
                num1++;
            }
            else {
                System.out.println("다름");
                num2++;
            }
            
            System.out.println(num1 + " " + num2);
            if(num1 == num2) {
                answer++;
                index = i + 1;
                num1 = 0;
                num2 = 0;
            } else if(num1 != num2 && i == length - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}