import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rePq = new PriorityQueue<>(Collections.reverseOrder());

        int num = Integer.parseInt(br.readLine().trim());

        rePq.offer(num);
        sb.append(rePq.peek()).append("\n");

        for(int i = 1; i < N; i++) {
            num = Integer.parseInt(br.readLine().trim());

            if(num > rePq.peek()) {
                pq.offer(num);

                if(pq.size() > rePq.size()) rePq.offer(pq.poll());
            } else {
                rePq.offer(num);

                if(pq.size() - rePq.size() < -1) pq.offer(rePq.poll());
            }

            sb.append(rePq.peek()).append("\n");
        }

        System.out.println(sb);
    }
}