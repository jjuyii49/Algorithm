import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        comb(0, new ArrayList<>());

        System.out.println(sb);
    }

    private static void comb(int count, ArrayList<Integer> list) {
        if(count == M) {
            for(int i = 0; i < M; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            list.add(i);
            comb(count + 1, list);
            list.remove(list.size() - 1);
        }
    }
}