import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int total = 0;
        for(int i = 0; i < 3; i++) {
            total += picks[i];
        }
        
        int min = Math.min(total * 5, minerals.length);
        
        ArrayList<int[]> list = new ArrayList<>();
        
        loop : for(int i = 0, index = 0; i < min; i += 5, index++) {
            int sum = 0;
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            for(int j = i; j < i + 5; j++) {
                if(j >= minerals.length) break;
                switch (minerals[j]) {
                    case "diamond" -> {
                        sum += 25;
                        diamond++;
                    }
                    case "iron" -> {
                        sum += 5;
                        iron++;
                    }
                    case "stone" -> {
                        sum += 1;
                        stone++;
                    }
                }
            }
            
            list.add(new int[] {sum, diamond, iron, stone});
        }
        
        list.sort((o1, o2) -> - (o1[0] - o2[0]));
        
        for(int[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
        for(int[] arr : list) {
            if(picks[0] > 0) {
                answer += arr[1] + arr[2] + arr[3];
                picks[0]--;
            } else if(picks[1] > 0) {
                answer += arr[1] * 5 + arr[2] + arr[3];
                picks[1]--;
            } else if(picks[2] > 0) {
                answer += arr[0];
                picks[2]--;
            }
        }
        
        return answer;
    }
    
    
}