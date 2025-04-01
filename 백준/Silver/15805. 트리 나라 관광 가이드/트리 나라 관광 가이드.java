import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int a = Integer.parseInt(st.nextToken());
        map.put(a, -1);
        int before = a;
        int max = a;

        for(int i = 1; i < N; i++) {
            a = Integer.parseInt(st.nextToken());

            max = Math.max(max, a);

            Integer parent = map.get(a);
            if(parent == null) map.put(a, before);

            before = a;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= max; i++) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(max + 1);
        System.out.println(sb);
    }
}