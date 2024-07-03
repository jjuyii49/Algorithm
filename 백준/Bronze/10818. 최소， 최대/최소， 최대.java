import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());

            if(n < min) min = n;
            if(n > max) max = n;
        }

        System.out.println(min + " " + max);
    }
}