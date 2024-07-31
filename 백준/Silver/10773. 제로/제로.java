import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine().trim());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine().trim());

            if(input == 0) {
                stack.pop();
            }
            else {
                stack.push(input);
            }
        }

        int size = stack.size();
        int sum = 0;
        for(int i = 0; i < size; i++) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}