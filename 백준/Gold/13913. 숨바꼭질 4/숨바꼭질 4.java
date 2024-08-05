import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int[] path = new int[100001];
    static int[] dx = {-1, 1, 2};
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int time = bfs();
        result = new int[time + 1];

        result[0] = K;
        for(int i = 1; i < time + 1; i++) {
            result[i] = path[result[i - 1]];
        }

        System.out.println(time);
        for(int i = time; i >= 0; i--) {
            System.out.print(result[i] + " ");
        }
    }

    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {N, 0});
        visited[N] = true;
        path[N] = -1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            if(current[0] == K) return current[1];

            for(int i = 0; i < 3; i++) {
                int nx = current[0] + dx[i];
                if(i == 2) nx = current[0] * dx[i];

                if(nx < 0 || nx > 100000) continue;
                if(visited[nx]) continue;

                queue.offer(new int[] {nx, current[1] + 1});
                visited[nx] = true;
                path[nx] = current[0];
            }
        }

        return -1;
    }
}