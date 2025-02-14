import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine().trim());

            int N = M / 10 + 1;

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            List<Integer> answerList = new ArrayList<>();

            StringTokenizer st;
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());

                int count = 10;
                if(n == N - 1) count = M % 10;

                for (int m = 1; m <= count; m++) {
                    int num = Integer.parseInt(st.nextToken());

                    if(maxHeap.isEmpty()) maxHeap.offer(num);
                    else {
                        if(num > maxHeap.peek()) minHeap.offer(num);
                        else maxHeap.offer(num);

                        if(minHeap.size() > maxHeap.size() + 1) maxHeap.offer(minHeap.poll());
                        else if(maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll());
                    }

                    if(m % 2 == 1) {
                        if(minHeap.size() > maxHeap.size()) answerList.add(minHeap.peek());
                        else answerList.add(maxHeap.peek());
                    }
                }
            }

            int size = answerList.size();
            sb.append(size).append("\n");

            N = size / 10 + 1;

            for(int i = 0; i < N; i++) {
                int count = 10;
                if(i == N - 1) count = size % 10;

                for(int j = 0; j < count; j++) {
                    int index = i * 10 + j;
                    sb.append(answerList.get(index)).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}