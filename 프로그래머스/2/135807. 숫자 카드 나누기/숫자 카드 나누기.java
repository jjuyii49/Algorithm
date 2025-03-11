import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0], gcdB = arrayB[0];
        for(int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        boolean checkA = true, checkB = true;
        for(int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] % gcdB == 0) {
                checkA = false;
                break;
            }
        }
        
        for(int i = 0; i < arrayB.length; i++) {
            if(arrayB[i] % gcdA == 0) {
                checkB = false;
                break;
            }
        }
        
        System.out.println("gcdA gcdB : " + gcdA + " " + gcdB);
        System.out.println("checkA checkB : " + checkA + " " + checkB);
        if(checkA && checkB) answer = Math.max(gcdA, gcdB);
        else {
            if(checkA) answer = gcdB;
            if(checkB) answer = gcdA;
        }
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}