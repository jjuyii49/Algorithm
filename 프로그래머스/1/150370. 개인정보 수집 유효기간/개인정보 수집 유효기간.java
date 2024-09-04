import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] date = today.split("\\.");
        
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        
        Map<String, Integer> term = new HashMap<>();
        for(String t : terms) {
            String[] arr = t.split(" ");
            
            int expire = Integer.parseInt(arr[1]) * 28;
            
            term.put(arr[0], expire);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] pDate = privacy[0].split("\\.");
            
            int y = Integer.parseInt(pDate[0]);
            int m = Integer.parseInt(pDate[1]);
            int d = Integer.parseInt(pDate[2]);
            
            int days = ((year - y) * 12 + (month - m)) * 28 + day - d;
            
            int expire = term.get(privacy[1]);
            
            if(days >= expire) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}