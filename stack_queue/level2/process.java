import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
           queue.offer(new int[]{priorities[i], i});
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            boolean hasHigher = false;

                for (int[] q : queue) {
                if (q[0] > cur[0]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(cur); 
            } else {
                answer++; 
                if (cur[1] == location) {
                    return answer; 
                }
            }
        }

        return answer;
    }
}
