import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = br.readLine().trim();

            if(input.equals("0")) return;

            StringTokenizer st = new StringTokenizer(input);

            n = Integer.parseInt(st.nextToken());
            num = new int[n];

            for(int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(num);
            comb(0, 0, new ArrayList<>());
            System.out.println();
        }
    }

    private static void comb(int index, int count, ArrayList<Integer> list) {
        if(count == 6) {
            for(int i = 0; i < 6; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i = index; i < n; i++) {
            list.add(num[i]);
            comb(i + 1, count + 1, list);
            list.remove(list.size() - 1);
        }
    }
}