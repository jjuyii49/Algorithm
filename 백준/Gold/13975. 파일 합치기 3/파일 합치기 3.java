import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine().trim());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int k = 0; k < K; k++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long answer = 0;
            while(pq.size() > 1) {
                long temp = pq.poll() + pq.poll();

                pq.offer(temp);
                answer += temp;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}