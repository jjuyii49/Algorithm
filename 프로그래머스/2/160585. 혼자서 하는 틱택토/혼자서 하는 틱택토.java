import java.util.*;

class Solution {
    
    public int solution(String[] board) {
        int answer = -1;
        
        int[][] row = new int[2][3];
        int[][] col = new int[2][3];
        int[][] dia = new int[2][2];
        
        int o = 0, x = 0;
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == 'O') o++;
                else if(board[i].charAt(j) == 'X') x++;
            }
        }
        
        if(x > o) {
            System.out.println("후공이 더 많이 놓음");
            return 0; // 후공이 더 많이 놓은 경우
        }
        
        if(o - x > 1) return 0;
        
        
        // 행별 o와 x 개수 구하기
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == 'O') row[0][i]++;
                else if(board[i].charAt(j) == 'X') row[1][i]++;
            }
        }
        
        // 열별 o와 x 개수 구하기
        for(int j = 0; j < 3; j++) {
            for(int i = 0; i < 3; i++) {
                if(board[i].charAt(j) == 'O') col[0][j]++;
                else if(board[i].charAt(j) == 'X') col[1][j]++;
            }
        }
        
        // 대각 o와 x 개수 구하기
        if(board[0].charAt(0) == 'O') dia[0][0]++;
        else if(board[0].charAt(0) == 'X') dia[1][0]++;
        
        if(board[1].charAt(1) == 'O') {
            dia[0][0]++;
            dia[0][1]++;
        }
        else if(board[1].charAt(1) == 'X') {
            dia[1][0]++;
            dia[1][1]++;
        }
        
        if(board[2].charAt(2) == 'O') dia[0][0]++;
        else if(board[2].charAt(2) == 'X') dia[1][0]++;
        
        if(board[0].charAt(2) == 'O') dia[0][1]++;
        else if(board[0].charAt(2) == 'X') dia[1][1]++;
        
        if(board[2].charAt(0) == 'O') dia[0][1]++;
        else if(board[2].charAt(0) == 'X') dia[1][1]++;
        
        
        System.out.println("행 o 개수 " + Arrays.toString(row[0]));
        System.out.println("행 x 개수 " + Arrays.toString(row[1]));
        System.out.println("열 o 개수 " + Arrays.toString(col[0]));
        System.out.println("열 x 개수 " + Arrays.toString(col[1]));
        System.out.println("대각선 o 개수 " + Arrays.toString(dia[0]));
        System.out.println("대각선 x 개수 " + Arrays.toString(dia[1]));
        
        boolean oWin = false, xWin = false;
        
        for(int i = 0; i < 3; i++) {
            if(row[0][i] == 3) {
                System.out.println(i + "행 o 3개");
                oWin = true;
            }
            if(row[1][i] == 3) {
                System.out.println(i + "행 x 3개");
                xWin = true;
            }
            if(col[0][i] == 3) {
                System.out.println(i + "열 o 3개");
                oWin = true;
            }
            if(col[1][i] == 3) {
                System.out.println(i + "열 x 3개");
                xWin = true;
            }
        }
        
        for(int i = 0; i < 2; i++) {
            if(dia[0][i] == 3) {
                System.out.println(i + "대각선 o 3개");
                oWin = true;
            }
            if(dia[1][i] == 3) {
                System.out.println(i + "대각선 x 3개");
                xWin = true;
            }
        }
        
        System.out.println(oWin + " " + xWin);
        if(oWin && xWin) {
            System.out.println("안됨");
            return 0;
        }
        else if(oWin && o == x) {
            System.out.println("안됨");
            return 0;
        }
        else if(xWin && o > x) return 0;
        else return 1;
        
    }
}