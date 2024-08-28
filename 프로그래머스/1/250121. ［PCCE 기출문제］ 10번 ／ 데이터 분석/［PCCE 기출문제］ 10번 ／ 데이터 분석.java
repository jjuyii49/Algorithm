import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extNum = 0;
        switch (ext) {
            case "code" -> extNum = 0;
            case "date" -> extNum = 1;
            case "maximum" -> extNum = 2;
            case "remain" -> extNum = 3;
        }

        int sortNum = 0;
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

        int n = list.size();
        int m = 4;
        
        int[][] answer = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            answer[i] = list.get(i);
        }

        for(int i = 1; i < n; i++) {
            int[] key = answer[i];

            int j;

            for(j = i - 1; j >= 0; j--) {
                if(answer[j][sortNum] > key[sortNum]) answer[j + 1] = answer[j];
                else break;
            }

            answer[j + 1] = key;
        }
        
        return answer;
    }
}