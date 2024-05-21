import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().trim().split("-");

        int[] number = new int[input.length];
        int idx = 0;
        for(int i = 0; i < input.length; i++) {
            String[] temp = input[i].split("\\+");
            int num = 0;
            for(int j = 0; j < temp.length; j++) {
                num += Integer.parseInt(temp[j]);
            }
            number[idx++] = num;
        }

        int result = number[0];
        for(int i = 1; i < number.length; i++) {
            result -= number[i];
        }

        System.out.println(result);
    }
}