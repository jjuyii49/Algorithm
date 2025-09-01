import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static int N;
    static int[] arr = {1, 5, 10, 50};
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        set = new HashSet<>();

        comb(0, 0, new ArrayList<>(), 0);

        System.out.println(set.size());
    }

    private static void comb(int idx, int count, List<Integer> list, int sum) {
        if(count == N) {
            set.add(sum);
            return;
        }

        for(int i = idx; i < 4; i++) {
            list.add(arr[i]);
            comb(i, count + 1, list, sum + arr[i]);
            list.remove(list.size() - 1);
        }
    }
}
