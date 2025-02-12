import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]) return -(o1[1] - o2[1]);

            return o1[0] - o2[0];
        });

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {d, n});
        }

        PriorityQueue<Integer> num = new PriorityQueue<>();

        int day = 1;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(day <= cur[0]) {
                num.offer(cur[1]);
                day++;
            } else {
                if(cur[1] > num.peek()) {
                    num.poll();
                    num.offer(cur[1]);
                }
            }
        }

        int answer = 0;
        while(!num.isEmpty()) {
            answer += num.poll();
        }

        System.out.println(answer);
    }
}