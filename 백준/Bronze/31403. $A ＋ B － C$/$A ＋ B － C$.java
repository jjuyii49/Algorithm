import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine().trim();
        String B = br.readLine().trim();
        String C = br.readLine().trim();

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        int c = Integer.parseInt(C);

        System.out.println(a + b - c);
        System.out.println(Integer.parseInt(A + B) - c);
    }
}