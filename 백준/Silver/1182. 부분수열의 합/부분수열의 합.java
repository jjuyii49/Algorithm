import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;

public class Main {

    static int N, S, answer;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        answer = 0;
        for(int i = 1; i <= N; i++) {
            comb(0, 0, i, 0);
        }

        System.out.println(answer);
    }

    private static void comb(int idx, int count, int n, int sum) {
        if(count == n) {
            if(sum == S) answer++;
            return;
        }

        for(int i = idx; i < N; i++) {
            comb(i + 1, count + 1, n, sum + num[i]);
        }
    }
}