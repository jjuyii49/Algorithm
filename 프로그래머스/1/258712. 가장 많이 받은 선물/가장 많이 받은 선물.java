class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int size = friends.length;

        // map 생성
        int[][] map = new int[size][size];

        for (String s : gifts) {
            String[] gift = s.split(" ");

            int a = 0;
            int b = 0;

            for (int j = 0; j < size; j++) {
                if (gift[0].equals(friends[j])) {
                    a = j;
                } else if (gift[1].equals(friends[j])) {
                    b = j;
                }
            }

            map[a][b]++;
        }

        // 선물 지수 계산
        int[] giftCount = new int[size];

        for(int i = 0; i < size; i++) {
            int gCount = 0;
            int rCount = 0;
            for(int j = 0; j < size; j++) {
                if(i == j) continue;

                gCount += map[i][j];
                rCount += map[j][i];
            }

            giftCount[i] = gCount - rCount;
        }

        // 다음 달 선물 계산
        int[] nextMonth = new int[size];
        boolean[][] visited = new boolean[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(i == j) continue;
                if(visited[i][j] || visited[j][i]) continue;

                // 둘 다 주고받지 않았거나 주고 받은 수가 같은 경우
                if(map[i][j] == 0 && map[j][i] == 0 || map[i][j] == map[j][i]) {
                    if(giftCount[i] > giftCount[j]) {
                        nextMonth[i]++;
                    } else if(giftCount[i] < giftCount[j]) {
                        nextMonth[j]++;
                    }
                } else if(map[i][j] > map[j][i]) {  // i가 더 많이 줬을 경우
                    nextMonth[i]++;
                } else if(map[i][j] < map[j][i]) {  // j가 더 많이 줬을 경우
                    nextMonth[j]++;
                }

                visited[i][j] = visited[j][i] = true;
            }
        }

        for(int i = 0; i < size; i++) {
            answer = Math.max(answer, nextMonth[i]);
        }
        
        return answer;
    }
}