class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int temp = 0;
        while(n >= a) {
            temp = n % a;
            n = (n / a) * b;
            answer += n;
            n += temp;
        }
        
        return answer;
    }
}