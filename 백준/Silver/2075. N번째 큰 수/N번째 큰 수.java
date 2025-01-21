import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Integer>[] maxHeaps = new PriorityQueue[N];
        for(int i = 0; i < N; i++) {
            maxHeaps[i] = new PriorityQueue<>(Collections.reverseOrder());

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j = 0; j < N; j++) {
                maxHeaps[i].offer(Integer.parseInt(st.nextToken()));
            }
        }

        int idx = N - 1;
        int count = 0;

        while(count++ < N) {
            int[] temp = new int[] {Integer.MIN_VALUE, 0};

            for(int i = idx; i >= 0; i--) {
                if(maxHeaps[i].isEmpty()) {
                    idx--;
                    continue;
                }

                if(temp[0] < maxHeaps[i].peek()) {
                    temp[0] = maxHeaps[i].peek();
                    temp[1] = i;
                }
            }

            if(count == N) System.out.println(maxHeaps[temp[1]].poll());
            else maxHeaps[temp[1]].poll();
        }

    }
}