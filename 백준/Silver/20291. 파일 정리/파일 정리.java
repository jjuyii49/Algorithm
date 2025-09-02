import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("\\.");
            int count = map.getOrDefault(input[1], 0);
            if(count == 0) list.add(input[1]);
            map.put(input[1],  count + 1);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            sb.append(str).append(" ").append(map.get(str)).append("\n");
        }

        System.out.println(sb);
    }
}
