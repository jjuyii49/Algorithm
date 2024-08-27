class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int time = 0;
        int end = attacks[attacks.length - 1][0];

        int index = 0;
        int current = health;
        int success = 0;
        while(time++ < end) {

            // 몬스터 공격
            if(time == attacks[index][0]) {
                success = 0;
                current -= attacks[index][1];

                if(current <= 0) {    // 캐릭터 사망
                    return -1;
                }

                index++;
            } else {    // 공격하지 않은 경우
                if(current < health) {  // 붕대감기 시작
                    current = Math.min(current + bandage[1], health);   // 회복
                    if(++success == bandage[0]) {
                        current  = Math.min(current + bandage[2], health);  // 연속 성공한 경우 추가 회복
                        success = 0;
                    }
                } else if (current == health) {
                    success++;
                }
            }
        }

        answer = current;
        
        return answer;
    }
}