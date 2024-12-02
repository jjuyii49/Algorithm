import java.util.*;

class Solution {
    
    int n;
    int[] count;
    public int[] solution(String[] id_list, String[] report, int k) {
        n = id_list.length;
        count = new int[n];
        
        int[] answer = new int[n];
        
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        for(int i = 0; i < report.length; i++) {
            String[] arr = report[i].split(" ");
            
            ArrayList<String> list = map.getOrDefault(arr[1], new ArrayList<>());
            
            if(list.contains(arr[0])) continue;
            
            list.add(arr[0]);
            
            map.put(arr[1], list);
    
            int num = nameToInt(arr[1], id_list);
            count[num]++;
        }
        
        for(int i = 0; i < n; i++) {
            if(count[i] >= k) {
                List<String> list = map.getOrDefault(id_list[i], new ArrayList<>());
                
                for(int j = 0; j < list.size(); j++) {
                    int num = nameToInt(list.get(j), id_list);
                    answer[num]++;
                }
            }
        }
        
        return answer;
    }
    
    private int nameToInt(String name, String[] id_list) {
        for(int i = 0; i < n; i++) {
            if(name.equals(id_list[i])) return i;
        }
        
        return -1;
    }
}