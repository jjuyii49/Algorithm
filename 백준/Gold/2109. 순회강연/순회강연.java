import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]) return -(o1[0] - o2[0]);

            return o1[1] - o2[1];
        });

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {p, d});
        }

        PriorityQueue<Integer> money = new PriorityQueue<>();
        int day = 1;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(cur[1] >= day) {
                money.offer(cur[0]);
                day++;
            } else {
                if(cur[0] > money.peek()) {
                    money.poll();
                    money.offer(cur[0]);
                }
            }
        }

        int answer = 0;
        while(!money.isEmpty()) {
            answer += money.poll();
        }

        System.out.println(answer);
    }
}