import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine().trim());

            Map<String, Integer> map = new HashMap<>();

            for(int n = 0; n < N; n++) {
                String[] input = br.readLine().split(" ");

                map.put(input[1], map.getOrDefault(input[1], 0) + 1);
            }

            long answer = 1;

            for(int size : map.values()) {
                answer *= (size + 1);
            }

            System.out.println(answer - 1);
        }
    }
}
