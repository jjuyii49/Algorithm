import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels[i][0] = m;
            jewels[i][1] = v;
        }

        // 보석 무게 순 오름차순, 가격 순 내림차순 정렬
        Arrays.sort(jewels, (o1, o2) -> {
            if(o1[0] == o2[0]) return -(o1[1] - o2[1]);

            return o1[0] - o2[0];
        });

        int[] bags = new int[K];
        for(int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine().trim());
        }

        // 가방 오름차순 정렬
        Arrays.sort(bags);

        long answer = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for(int bag : bags) {
            while(j < N && jewels[j][0] <= bag) {
                maxHeap.offer(jewels[j][1]);
                j++;
            }

            if(!maxHeap.isEmpty()) answer += maxHeap.poll();
        }

        System.out.println(answer);
    }
}