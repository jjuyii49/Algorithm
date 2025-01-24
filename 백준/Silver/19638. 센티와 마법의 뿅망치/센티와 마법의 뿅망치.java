import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int centi = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++) {
            maxHeap.offer(Integer.parseInt(br.readLine().trim()));
        }

        int count = 0;
        while(T-- > 0) {
            if(centi > maxHeap.peek() || maxHeap.peek() == 1) break;

            maxHeap.offer(maxHeap.poll() / 2);
            count++;
        }

        if(centi <= maxHeap.peek()) {
            System.out.println("NO");
            System.out.println(maxHeap.peek());
        } else {
            System.out.println("YES");
            System.out.println(count);
        }
    }
}