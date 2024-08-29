import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            hashMap.put(players[i], i);
        }

        for(String call : callings) {
            int rank = hashMap.get(call);

            String temp = players[rank - 1];
            players[rank - 1] = call;
            players[rank] = temp;

            hashMap.replace(call, rank - 1);
            hashMap.replace(players[rank], rank);
        }
        
        return players;
    }
}