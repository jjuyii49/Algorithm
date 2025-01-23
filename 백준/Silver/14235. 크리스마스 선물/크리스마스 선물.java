import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            String input = br.readLine().trim();

            if(input.equals("0")) {
                if(maxHeap.isEmpty()) System.out.println(-1);
                else System.out.println(maxHeap.poll());
            } else {
                StringTokenizer st = new StringTokenizer(input);

                int a = Integer.parseInt(st.nextToken());
                for(int j = 0; j < a; j++) {
                    maxHeap.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
}