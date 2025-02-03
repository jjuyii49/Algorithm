import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> name = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            String input = br.readLine().trim();

            name.put(input, 1);
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine().trim();

            int temp = name.getOrDefault(input, 0);

            if(temp == 1) pq.offer(input);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");

        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }

}