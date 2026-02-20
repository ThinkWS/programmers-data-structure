import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            
            if (answers[i] == p1[i % p1.length]) score1++;
            if (answers[i] == p2[i % p2.length]) score2++;
            if (answers[i] == p3[i % p3.length]) score3++;
        }
        
        int max = Math.max(score1, Math.max(score2, score3));
        
        List<Integer> result = new ArrayList<>();
        
        if (score1 == max) result.add(1);
        if (score2 == max) result.add(2);
        if (score3 == max) result.add(3);
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
