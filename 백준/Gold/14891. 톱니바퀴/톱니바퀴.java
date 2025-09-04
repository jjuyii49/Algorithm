import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static String[] wheels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        wheels = new String[4];
        for(int i = 0; i < 4; i++) {
            wheels[i] = br.readLine();
        }

        int K = Integer.parseInt(br.readLine().trim());
        for(int k = 0; k < K; k++) {
            String[] input = br.readLine().split(" ");
            int idx = Integer.parseInt(input[0]);
            int dir = Integer.parseInt(input[1]);

            int[] rotateDir = new int[4];
            rotateDir[idx - 1] = dir;

            for(int i = idx - 1; i > 0; i--) {
                if(wheels[i].charAt(6) != wheels[i - 1].charAt(2)) {
                    if(rotateDir[i] == 1) rotateDir[i - 1] = -1;
                    else rotateDir[i - 1] = 1;
                } else break;
            }

            for(int i = idx - 1; i < 3; i++) {
                if(wheels[i].charAt(2) != wheels[i + 1].charAt(6)) {
                    if(rotateDir[i] == 1) rotateDir[i + 1] = -1;
                    else rotateDir[i + 1] = 1;
                } else break;
            }

            for(int i = 0; i < 4; i++) {
                if(rotateDir[i] == 0) continue;
                rotate(i, rotateDir[i]);
            }

        }

        int answer = (wheels[0].charAt(0) == '1'? 1:0) + (wheels[1].charAt(0) == '1'? 2:0) + (wheels[2].charAt(0) == '1'? 4:0) + (wheels[3].charAt(0) == '1'? 8:0);

        System.out.println(answer);
    }

    private static void rotate(int idx, int dir) {
        if(dir == 1) {
            String temp = wheels[idx].charAt(7) + "";
            wheels[idx] = temp + wheels[idx].substring(0, 7);
        } else {
            String temp = wheels[idx].charAt(0) + "";
            wheels[idx] = wheels[idx].substring(1, 8) + temp;
        }
    }
}