import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int K, N;
    static int[] graph;
    static List<Integer>[] lists;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        N = (int)(Math.pow(2, K) - 1);

        String[] input = br.readLine().split(" ");
        queue = new ArrayDeque<>();
        for(int i = 0; i < input.length; i++) {
            queue.offer(Integer.parseInt(input[i]));
        }

        graph = new int[N + 1];
        lists = new ArrayList[K];
        for(int i = 0; i < K; i++) {
            lists[i] = new ArrayList<>();
        }

        inorder(1, 0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++) {
            for(int j = 0; j < lists[i].size(); j++) {
                sb.append(lists[i].get(j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void inorder(int index, int count) {
        if(count >= K - 1) return;

        int left = index * 2;
        int right = index * 2 + 1;

        inorder(left, count + 1);

        if(graph[left] == 0) {
            graph[left] = queue.poll();
            lists[count + 1].add(graph[left]);
        }
        if(graph[index] == 0) {
            graph[index] = queue.poll();
            lists[count].add(graph[index]);
        }

        inorder(right, count + 1);

        if(graph[right] == 0) {
            graph[right] = queue.poll();
            lists[count + 1].add(graph[right]);
        }
    }
}