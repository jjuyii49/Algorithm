import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine().trim());

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            minHeap.offer(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++) {
            long x = minHeap.poll();
            long y = minHeap.poll();

            long sum = x + y;
            minHeap.offer(sum);
            minHeap.offer(sum);
        }

        long answer = 0;

        while(!minHeap.isEmpty()) {
            answer += minHeap.poll();
        }

        System.out.println(answer);
    }
}