class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            int count = 0;
            char cur = s.charAt(i);
            
            while(count < index) {
                char next = (char)(cur + 1);
                if(next - 'a' >= 26) {
                    next = (char)((next - 'a') % 26 + 'a');
                }
                
                if(!skip.contains(next + "")) {
                    count++;
                }
                
                cur = next;
            }
            
            answer += cur;
        }
        
        return answer;
    }
}