import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = 0;
        int max = 0;
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            int narin = Integer.parseInt(st.nextToken());
            int tan = Integer.parseInt(st.nextToken());

            p = p + tan - narin;

            if(max < p) max = p;
        }

        System.out.println(max);
    }
}