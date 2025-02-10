import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];

            return o1[0] - o2[0];
        });

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            pq.offer(new int[] {s, t});
        }

        PriorityQueue<Integer> endTime = new PriorityQueue<>();

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(!endTime.isEmpty() && cur[0] >= endTime.peek()) endTime.poll();

            endTime.offer(cur[1]);
        }

        System.out.println(endTime.size());

    }
}