import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] buildings = new int[N];
        for(int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine().trim());

            buildings[i] = height;
        }

        long answer = 0;
        for(int i = 0; i < N; i++) {
            int temp = buildings[i];

            for(int j = i + 1; j < N; j++) {
                if(temp <= buildings[j]) break;

                answer++;
            }
        }

        System.out.println(answer);

    }
}
