import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        
        // 1. 차량을 진출 지점 기준으로 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int camera = Integer.MIN_VALUE;
        int count = 0;
        
        for(int[] route : routes){
            
           
            if(camera < route[0]){
                camera = route[1]; 
                count++;
            }
        }
        
        return count;
    }
}
