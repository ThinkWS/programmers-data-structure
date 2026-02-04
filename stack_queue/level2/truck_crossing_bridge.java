import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>(); 
        Queue<Integer> trucks = new LinkedList<>(); 
        for (int t : truck_weights) trucks.offer(t);
        
        int time = 0;
        int currentWeight = 0; 

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0); 
        }

        while (!bridge.isEmpty()) {
            time++;
            currentWeight -= bridge.poll();

            if (!trucks.isEmpty()) {
                if (currentWeight + trucks.peek() <= weight) {
                    int truck = trucks.poll();
                    bridge.offer(truck);
                    currentWeight += truck;
                } else {
                    bridge.offer(0); 
            }
        }
        }
        return time;
    }
}
