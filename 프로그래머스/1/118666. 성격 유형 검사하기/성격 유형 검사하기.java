class Solution {
    
    int[] personality = new int[8]; // R, T, C, F, J, M, A, N
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        int t = survey.length;
        for(int i = 0; i < t; i++) {
            int score = choices[i];
            int neg = charToInt(survey[i].charAt(0));
            int pos = charToInt(survey[i].charAt(1));
            
            switch(score) {
                case 1 -> personality[neg] += 3;
                case 2 -> personality[neg] += 2;
                case 3 -> personality[neg]++;
                case 5 -> personality[pos]++;
                case 6 -> personality[pos] += 2;
                case 7 -> personality[pos] += 3;
            }
        }
        
        for(int i = 0; i < 8; i += 2) {
            int max = i;
            
            if(personality[i] < personality[i + 1]) max = i + 1;
            
            answer += intToString(max);
        }
        
        return answer;
    }
    
    private int charToInt(char ch) {
        switch(ch) {
            case 'R': return 0;
            case 'T': return 1;
            case 'C': return 2;
            case 'F': return 3;
            case 'J': return 4;
            case 'M': return 5;
            case 'A': return 6;
            case 'N': return 7;
        }
        
        return -1;
    }
    
    private String intToString(int index) {
        switch(index) {
            case 0: return "R";
            case 1: return "T";
            case 2: return "C";
            case 3: return "F";
            case 4: return "J";
            case 5: return "M";
            case 6: return "A";
            case 7: return "N";
        }
        
        return "";
    }
}