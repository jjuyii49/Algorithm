import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int[] dn = {2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    static int bfs(int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {n, 0});
        visited[n] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            if(current[0] == K) return current[1];
            for(int i = 0; i < 3; i++) {
                int nn = current[0] + dn[i];
                if(i == 0) {
                    nn = current[0] * dn[i];
                }

                if(nn < 0 || nn >= 100001) continue;
                if(visited[nn]) continue;

                queue.offer(new int[] {nn, i == 0? current[1] : current[1] + 1});
                visited[nn] = true;
            }
        }

        return -1;
    }
}