import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int F, S, G, U, D, visited[];
    static ArrayList<Integer> diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        if(S == G) {
            System.out.println(0);
            return;
        }

        visited = new int[F + 1];
        for(int i = 0; i < F + 1; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        visited[S] = 0;

        diff = new ArrayList<>();
        diff.add(U);
        diff.add(D * (-1));

        int result = bfs();
        System.out.println(result > 0? result : "use the stairs");
    }

    static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(S);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int i = 0; i < 2; i++) {
                int floor = current + diff.get(i);

                if(floor < 1 || floor > F) continue;
                if(visited[floor] != Integer.MAX_VALUE) continue;
                if(floor == G) {
                    visited[floor] = visited[current] + 1;
                    return visited[floor];
                }

                queue.offer(floor);
                visited[floor] = Math.min(visited[floor], visited[current] + 1);
            }
        }

        return -1;
    }
}