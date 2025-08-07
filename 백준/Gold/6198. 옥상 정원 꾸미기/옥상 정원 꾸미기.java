import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Stack<Integer> stack = new Stack<>();
        long answer = 0;

        for(int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine().trim());

            while(!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }

            answer += stack.size();
            stack.push(height);
        }

        System.out.println(answer);

    }
}
