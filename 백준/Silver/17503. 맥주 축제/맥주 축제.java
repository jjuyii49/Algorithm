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
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> beers = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]) return -(o1[0] - o2[0]); // 선호도 내림차순

            return o1[1] - o2[1];   // 도수레벨 오름차순
        });

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            beers.offer(new int[] {v, c});
        }

        PriorityQueue<Integer> prefer = new PriorityQueue<>();
        int sum = 0, min = -1;

        while(!beers.isEmpty()) {
            int[] current = beers.poll();
            sum += current[0];
            prefer.offer(current[0]);

            if(prefer.size() > N) sum -= prefer.poll();

            if(prefer.size() == N && sum >= M) {
                min = current[1];
                break;
            }
        }

        System.out.println(min);
    }
}