import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, students[], count;
    static boolean[] visited, team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine().trim());

            students = new int[n + 1];
            visited = new boolean[n + 1];
            team = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            count = 0;
            for(int i = 1; i < n + 1; i++) {
                int num = Integer.parseInt(st.nextToken());
                students[i] = num;
                if(i == num) {
                    team[i] = true;
                    visited[i] = true;
                    count++;
                }
            }

            for(int i = 1; i < n + 1; i++) {
                if(!team[i]) {
                    dfs(i);
                }
            }

            sb.append(n - count).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int num) {
        if(team[num]) return;

        if(visited[num]) {
            team[num] = true;
            count++;
        }

        visited[num] = true;
        dfs(students[num]);
        visited[num] = false;
        team[num] = true;
    }
}