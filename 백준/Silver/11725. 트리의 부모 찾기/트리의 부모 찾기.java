import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, List<Integer>> map;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        map = new HashMap<>();

        StringTokenizer st;
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine().trim());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> list = map.getOrDefault(a, new ArrayList<>());
            list.add(b);
            map.put(a, list);

            list = map.getOrDefault(b, new ArrayList<>());
            list.add(a);
            map.put(b, list);
        }

        parents = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            tree(i);
        }

        for(int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    static void tree(int index) {
        List<Integer> list = map.get(index);

        for(Integer num : list) {
            if(visited[num]) parents[index] = num;
            else {
                visited[num] = true;
                tree(num);
            }
        }
    }
}
