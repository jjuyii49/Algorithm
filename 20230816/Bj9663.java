import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

/*public class Bj9663 {

	static int N;
	static int[] col;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		col = new int[N + 1];
		setQueen(1);
		
		System.out.println(ans);
	}
	
	private static void setQueen(int row) {
		
		if(!isAvailable(row - 1)) return;
		
		if(row > N) {
			ans++;
			return;
		}
		
		for(int i = 1; i < N + 1; i++) {
			col[row] = i;
			setQueen(row + 1);
		}
	}
	
	private static boolean isAvailable(int row) {

		for(int i = 1; i < row; i++) {
			if(col[i] == col[row] || row - i == Math.abs(col[row]- col[i])) {
				return false;
			}
		}
		
		return true;
	}

}*/

public class Bj9663 {
	
	static int N;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		setQueen(0, 0, 0, 0);
		
		System.out.println(count);
	}
	
	private static void setQueen(int row, int left, int center, int right) {
		if(row == N) {
			count++;
			return;
		}
		
		left <<= 1;
		right >>= 1;
		
		int board = left | center | right;
		
		if((board & ~(1 << N)) == ~(1 << N)) return;
		
		for(int i = 0; i < N; i++) {
			int flag = 1 << i;
			
			if((board & flag) == 0) setQueen(row + 1, left | flag, center | flag, right | flag);
		}
	}
}
