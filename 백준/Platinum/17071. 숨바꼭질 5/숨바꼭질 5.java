import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[][] visited = new boolean[2][500001];
    static int[] dn = {2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {N, 0}); // N, time
        visited[0][N] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            int n = current[0];
            int time = current[1];
            int k = K + time * (time + 1) / 2;

            int evenOdd = (time + 1) % 2;

            if(k > 500000) return -1;
            if(visited[time % 2][k]) return time;

            for(int i = 0; i < 3; i++) {
                int nn = n + dn[i];
                if(i == 0) nn = n * dn[i];

                if(nn < 0 || nn >= 500001) continue;
                if(!visited[evenOdd][nn]) {
                    queue.offer(new int[]{nn, time + 1});
                    visited[evenOdd][nn] = true;
                }
            }
        }

        return -1;
    }
}