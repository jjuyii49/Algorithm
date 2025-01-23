import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int dasom = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N - 1; i++) {
            maxHeap.offer(Integer.parseInt(br.readLine().trim()));
        }

        int answer = 0;
        while(!maxHeap.isEmpty() && dasom <= maxHeap.peek()) {
            dasom++;
            answer++;
            maxHeap.offer(maxHeap.poll() - 1);
        }

        System.out.println(answer);
    }
}