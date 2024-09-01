import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
       Arrays.sort(plans, (o1, o2) -> {
            String[] time1 = o1[1].split(":");
            String[] time2 = o2[1].split(":");

            int startH1 = Integer.parseInt(time1[0]);
            int startM1 = Integer.parseInt(time1[1]);
            int startH2 = Integer.parseInt(time2[0]);
            int startM2 = Integer.parseInt(time2[1]);

            if(startH1 == startH2) return startM1 - startM2;
            else return startH1 - startH2;
        });

        Stack<Integer> stack = new Stack<>();

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < plans.length; i++) {
            if(stack.isEmpty()) stack.push(i);    // 진행 중인 과제 없음
            else {  // 진행 중인 과제 있음
                // 진행 중인 과제
                int current = stack.peek();
                String[] time = plans[current][1].split(":");
                int hh = Integer.parseInt(time[0]);
                int mm = Integer.parseInt(time[1]);
                int playtime = Integer.parseInt(plans[current][2]);

                // 새로운 과제
                String[] nTime = plans[i][1].split(":");
                int nHH = Integer.parseInt(nTime[0]);
                int nMM = Integer.parseInt(nTime[1]);

                int dh = nHH - hh;
                int dm = nMM - mm;

                int tempTime = dh * 60 + dm;

                int t = tempTime - playtime;

                // 진행 중인 과제가 끝나는 시간과 새로운 과제 시작 시간이 같은 경우거나 끝나는 시간이 작은 경우
                if(t == 0) {
                    stack.pop();
                    list.add(plans[current][0]);
                }
                // 진행 중인 과제가 끝나는 시간이 새로운 과제 시작 시간보다 작은 경우
                else if(t > 0) {
                    stack.pop();
                    list.add(plans[current][0]);

                    while(!stack.isEmpty()) {
                        int pre = stack.peek();

                        int playTime = Integer.parseInt(plans[pre][2]);
                        t -= playTime;

                        if(t == 0) {
                            stack.pop();
                            list.add(plans[pre][0]);
                            break;
                        } else if(t > 0) {
                            stack.pop();
                            list.add(plans[pre][0]);
                        } else {
                            plans[pre][2] = Math.abs(t) + "";
                            break;
                        }
                    }
                }
                // 진행 중인 과제가 끝나기 전에 새로운 과제가 시작되는 경우
                else {
                    plans[current][2] = Math.abs(t) + "";
                }

                stack.push(i);
            }
        }

        while(!stack.isEmpty()) {
            int index = stack.pop();
            list.add(plans[index][0]);
        }
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}