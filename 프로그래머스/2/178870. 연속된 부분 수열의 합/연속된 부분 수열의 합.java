import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        
        int[] sum = new int[sequence.length];
        ArrayList<int[]> list = new ArrayList<>();

        sum[0] = sequence[0];
        if(sequence[0] == k) return new int[] {0, 0};

        for(int i = 1; i < sequence.length; i++) {
            if(sequence[i] == k) return new int[] {i, i};
            
            sum[i] = sum[i - 1] + sequence[i];

            if(sum[i] == k) list.add(new int[]{0, i, i + 1});
        }

        int i = 0;
        int j = 1;

        while(i < sequence.length && j < sequence.length) {
            int num = sum[j] - sum[i];

            if(num == k) {
                list.add(new int[] {i + 1, j, j - i});
                j++;
            } else if(num > k) {
                i++;
            } else {
                j++;
            }
        }

        list.sort(((o1, o2) -> o1[2] - o2[2]));

        int[] first = list.get(0);
        answer = new int[] {first[0], first[1]};
        
        return answer;
    }
}