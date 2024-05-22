import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();

        final String A = "AAAA";
        final String B = "BB";

        String tempX = "", tempP = "";
        List<String> result = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'X') {
                tempX += "X";

                if (!tempP.isEmpty()) {
                    result.add(tempP);
                    tempP = "";
                }

                if (i == input.length() - 1) {
                    result.add(tempX);
                }
            }
            else {
                tempP += ".";

                if (!tempX.isEmpty()) {
                    result.add(tempX);
                    tempX = "";

                }

                if (i == input.length() - 1) {
                    result.add(tempP);
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if(result.get(i).contains(".")) continue;

            int length = result.get(i).length();

            if (length % 2 != 0) {
                System.out.println(-1);
                return;
            }

            String temp = "";

            while (length > 0) {
                if (length / 4 > 0) {
                    temp += A;
                    length -= 4;
                } else {
                    temp += B;
                    length -= 2;
                }
            }

            result.set(i, temp);
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }
    }
}