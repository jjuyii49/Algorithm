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

        Map<Integer, PriorityQueue<Integer>> susi = new HashMap<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int count = Integer.parseInt(st.nextToken());

            for(int j = 0; j < count; j++) {
                int num = Integer.parseInt(st.nextToken());

                PriorityQueue<Integer> people = susi.getOrDefault(num, new PriorityQueue<>());
                people.offer(i);

                susi.put(num, people);
            }
        }

        int[] answer = new int[N];

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < M; i++) {
            int cur = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> people = susi.getOrDefault(cur, new PriorityQueue<>());

            if(people.isEmpty()) continue;

            answer[people.poll()]++;
        }

        for(int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}