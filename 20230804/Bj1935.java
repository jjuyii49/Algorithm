import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj1935 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int[] num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		double x = 0, y = 0;
		
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '*':
				y = stack.pop();
				x = stack.pop();
				stack.push(x * y);
				break;
			case '/':
				y = stack.pop();
				x = stack.pop();
				stack.push(x / y);
				break;
			case '+':
				y = stack.pop();
				x = stack.pop();
				stack.push(x + y);
				break;
			case '-':
				y = stack.pop();
				x = stack.pop();
				stack.push(x - y);
				break;
			default:
				double temp = num[ch-'A'];
				stack.push(temp);
			}
		}
		
		System.out.printf("%.2f\n", stack.pop());
	}

}
