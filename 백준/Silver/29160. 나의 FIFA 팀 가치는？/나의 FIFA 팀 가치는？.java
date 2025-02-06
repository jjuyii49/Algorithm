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

        Map<Integer, PriorityQueue<Integer>> players = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int num = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = players.getOrDefault(num, new PriorityQueue<>(Collections.reverseOrder()));
            pq.offer(value);

            players.put(num, pq);
        }

        while(K-- > 0) {
            for(int i = 0; i < 11; i++) {
                PriorityQueue<Integer> pq = players.get(i + 1);

                if(pq == null || pq.isEmpty()) continue;

                int v = pq.poll();

                pq.offer(Math.max(--v, 0));
                players.put(i + 1, pq);
            }
        }

        int sum = 0;
        for(int i = 0; i < 11; i++) {
            PriorityQueue<Integer> pq = players.get(i + 1);

            if(pq == null || pq.isEmpty()) continue;

            int v = pq.poll();

            sum += v;
        }

        System.out.println(sum);
    }
}