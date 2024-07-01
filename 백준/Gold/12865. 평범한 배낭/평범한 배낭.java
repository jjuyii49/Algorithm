import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K, max;
    static int[] weight, value;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weight = new int[N + 1];
        value = new int[N + 1];
        result = new int[N + 1][K + 1];

        for(int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            weight[i] = w;
            value[i] = v;
        }

        for(int i = 0; i < N + 1; i++) {
            result[i][0] = 0;
            result[0][i] = 0;
        }

        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < K + 1; j++) {
                if(weight[i] > j) result[i][j] = result[i - 1][j];
                else result[i][j] = Math.max(value[i] + result[i - 1][j - weight[i]], result[i - 1][j]);
            }
        }

        System.out.println(result[N][K]);
    }
}