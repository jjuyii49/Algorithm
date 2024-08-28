import java.util.*;

class Solution {
    
    int extNum, sortNum;
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        switch (ext) {
            case "code" -> extNum = 0;
            case "date" -> extNum = 1;
            case "maximum" -> extNum = 2;
            case "remain" -> extNum = 3;
        }

        switch (sort_by) {
            case "code" -> sortNum = 0;
            case "date" -> sortNum = 1;
            case "maximum" -> sortNum = 2;
            case "remain" -> sortNum = 3;
        }

        ArrayList<int[]> list = new ArrayList<>();

        for (int[] arr : data) {
            if (arr[extNum] < val_ext) list.add(arr);
        }

        list.sort((o1, o2) -> {
            return o1[sortNum] - o2[sortNum];
        });
        
        int n = list.size();
        int m = 4;
        
        int[][] answer = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}