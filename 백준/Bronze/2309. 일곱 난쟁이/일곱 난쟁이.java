import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int[] arr;
    static boolean[] isSelected;
    static boolean x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9];
        isSelected = new boolean[9];

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(arr);

        x = false;
        comb(0, 0, 0);
    }

    public static void comb(int index, int count, int sum) {
        if(sum > 100) return;

        if(count == 7) {
            if(sum == 100 && !x) {
                for (int i = 0; i < 9; i++) {
                    if (isSelected[i]) System.out.println(arr[i]);
                }
                x = true;
                return;
            } else {
                return;
            }
        } else if(count > 7) return;

        if(index > 8) return;

        isSelected[index] = true;
        comb(index + 1, count + 1, sum + arr[index]);
        isSelected[index] = false;
        comb(index + 1, count, sum);
    }
}