import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> present = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < N; i++) {
            present.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < M; i++) {
            int child = Integer.parseInt(st.nextToken());

            if(present.isEmpty() || child > present.peek()) {
                System.out.println(0);
                return;
            }

            present.offer(present.poll() - child);
        }

        System.out.println(1);
    }
}