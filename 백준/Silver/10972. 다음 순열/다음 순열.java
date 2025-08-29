import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int temp = arr[N - 1];
        StringBuilder sb = new StringBuilder();
        boolean last = true;
        
        for(int i = N - 2; i >= 0; i--) {
            if(temp > arr[i]) {
                int min = Integer.MAX_VALUE;
                int idx = -1;
                for(int j = i + 1; j < N; j++) {
                    if(arr[j] > arr[i] && min > arr[j]) {
                        min = arr[j];
                        idx = j;
                    }
                }
                temp = arr[i];
                arr[i] = min;
                arr[idx] = temp;

                for(int j = 0; j <= i; j++) {
                    sb.append(arr[j]).append(" ");
                }
                for(int j = N - 1; j > i; j--) {
                    sb.append(arr[j]).append(" ");
                }
                last = false;
                break;
            }

            temp = arr[i];
        }

        if(last) System.out.println(-1);
        else System.out.println(sb);
    }
}
