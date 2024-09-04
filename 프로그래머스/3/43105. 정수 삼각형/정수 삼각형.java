import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int n = triangle.length;
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                map[i][j] = triangle[i][j];
            }
        }
        
        int[][] dp = new int[n][n];
        dp[0][0] = map[0][0];
        dp[1][0] = dp[0][0] + map[1][0];
        dp[1][1] = dp[0][0] + map[1][1];
        
        for(int i = 2; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + map[i][j];
                } else if(j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + map[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + map[i][j];
                }
            }
        }
        
        answer = dp[n - 1][0];
        
        for(int i = 1; i < n; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }
        
        return answer;
    }
}