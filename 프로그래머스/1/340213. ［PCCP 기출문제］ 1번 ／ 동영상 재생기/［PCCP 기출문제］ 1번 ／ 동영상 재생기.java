class Solution {
    
    int startM, startS, endM, endS;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] video = video_len.split(":");
        int videoM = Integer.parseInt(video[0]);
        int videoS = Integer.parseInt(video[1]);
        
        String[] current = pos.split(":");
        int m = Integer.parseInt(current[0]);
        int s = Integer.parseInt(current[1]);
        
        String[] opStart = op_start.split(":");
        startM = Integer.parseInt(opStart[0]);
        startS = Integer.parseInt(opStart[1]);
        
        String[] opEnd = op_end.split(":");
        endM = Integer.parseInt(opEnd[0]);
        endS = Integer.parseInt(opEnd[1]);
        
        if(isOP(m, s)) {
                m = endM;
                s = endS;
        }
        
        for(String command : commands) {
            switch (command) {
                case "prev" -> {
                    s -= 10;
                    if(s < 0) {
                        s += 60;
                        m--;
                    }
                    
                    if(m < 0) m = s = 0;
                }
                case "next" -> {
                    s += 10;
                    if(s >= 60) {
                        s %= 60;
                        m++;
                    }
                    
                    if(m > videoM) {
                        m = videoM;
                        s = videoS;
                    } else if(m == videoM && s > videoS) {
                        m = videoM;
                        s = videoS;
                    }
                }
            }
            
            if(isOP(m, s)) {
                m = endM;
                s = endS;
            }
        }
        
        String mm = "", ss = "";
        
        if(m < 10) mm = "0" + m;
        else mm = m + "";
        
        if(s < 10) ss = "0" + s;
        else ss = s + "";
        
        answer = mm + ":" + ss;
        
        return answer;
    }
    
    private boolean isOP(int m, int s) {
        if(m > endM || m < startM) return false;
        else if(m == endM && s > endS || m == startM && s < startS) return false;
        else return true;
    }
}