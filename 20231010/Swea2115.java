import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea2115 {
	
	static int N, M, C, map[][], max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t < T + 1; t++) {
			sb.append("#").append(t).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append(comb()).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int comb() {
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= N-M; j++) {
				max = 0;
				honeyBenefit(i, j, 0, 0, 0);
				
				int max1 = max;
				
				max = 0;
				int max2 = 0;
				for(int k = j + M; k <= N - M; k++) {
					honeyBenefit(i, k, 0, 0, 0);
					max2 = Math.max(max2, max);
				}
				
				max = 0;
				for(int i2 = i + 1; i2 < N; i2++) {
					for(int j2 = 0; j2 <= N - M; j2++) {
						honeyBenefit(i2, j2, 0, 0, 0);
						max2 = Math.max(max2, max);
					}
				}
				
				result = Math.max(result, max1 + max2);
				
			}
		}
		
		return result;
	}
	
	private static void honeyBenefit(int r, int c, int cnt, int sum, int honey) {
		if(sum > C) {
			return;
		}
		
		if(cnt == M) {
			if(max < honey) {
				max = honey;
			}
			return;
		}
		
		honeyBenefit(r, c + 1, cnt + 1, sum + map[r][c], honey + map[r][c]*map[r][c]);
		honeyBenefit(r, c + 1, cnt + 1, sum, honey);
	}
}
