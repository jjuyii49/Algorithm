import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (o1, o2) -> {
            String[] time1 = o1[0].split(":");
            String[] time2 = o2[0].split(":");

            int h1 = Integer.parseInt(time1[0]);
            int m1 = Integer.parseInt(time1[1]);
            int h2 = Integer.parseInt(time2[0]);
            int m2 = Integer.parseInt(time2[1]);

            if(h1 != h2) return Integer.compare(h1, h2);
            else return Integer.compare(m1, m2);
        });

        
        List<String> list = new ArrayList<>();
        list.add(book_time[0][1]);
        
        for(int i = 1; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            
            int sh = Integer.parseInt(start[0]);
            int sm = Integer.parseInt(start[1]);
            
            boolean change = false;
            for(int j = 0; j < list.size(); j++) {
                String[] end = list.get(j).split(":");
                
                int eh = Integer.parseInt(end[0]);
                int em = Integer.parseInt(end[1]);
                
                int temp = (sh - eh) * 60 + sm - em;
                
                if(temp >= 10) {
                    list.set(j, book_time[i][1]);
                    change = true;
                    break;
                }
            }
            
            if(!change) list.add(book_time[i][1]);
        }
        
        answer = list.size();
        
        return answer;
    }
}