import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++) {
            maxHeap.offer(Integer.parseInt(br.readLine().trim()));
        }

        int y = 0, day = 0;
        List<Integer> list = new ArrayList<>();

        while(true) {
            if(maxHeap.isEmpty() || maxHeap.peek() <= K) break;

            int p = maxHeap.poll(); // 오늘 할 일 p
            y = y / 2 + p;  // 오늘 만족감
            p -= M; // 중요도 감소

            maxHeap.offer(p);

            day++;
            list.add(y);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(day).append("\n");
        for(int i = 0; i < day; i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}