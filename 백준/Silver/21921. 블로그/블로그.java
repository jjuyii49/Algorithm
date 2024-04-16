import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int index = 0;

        for(int i = 0; i < X; i++) {
            sum += arr[i];
        }

        int max = sum;
        int num = 1;

        for(int i = 0; i < N - X; i++) {
            sum = sum - arr[i] + arr[i + X];

            if(max == sum) num++;
            else if(max < sum) {
                max = sum;
                num = 1;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(num);
    }
}