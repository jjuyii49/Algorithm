import java.util.*;

class Solution {
    
    List<int[]>[] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        graph = new ArrayList[n + 1];
        
        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < fares.length; i++) {
            int x = fares[i][0];
            int y = fares[i][1];
            int weight = fares[i][2];
            
            graph[x].add(new int[] {y, weight});
            graph[y].add(new int[] {x, weight});
        }
        
        int[] distS = dijkstra(n, s);
        int[] distA = dijkstra(n, a);
        int[] distB = dijkstra(n, b);
        
        answer = distS[a] + distS[b];
        
        for(int i = 1; i < n + 1; i++) {
            answer = Math.min(answer, distS[i] + distA[i] + distB[i]);
        }
        
        return answer;
    }
    
    private int[] dijkstra(int n, int start) {
        int[] dist = new int[n + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        pq.offer(new int[] {start, 0});
        
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int cur = current[0];
            int curWeight = current[1];
            
            if(curWeight > dist[cur]) {
                continue;
            }
            
            for(int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i)[0];
                int nextWeight = graph[cur].get(i)[1];
                
                if(dist[next] > curWeight + nextWeight) {
                    dist[next] = curWeight + nextWeight;
                    pq.offer(new int[] {next, dist[next]});
                }
            }
        }
        
        return dist;
    }
}