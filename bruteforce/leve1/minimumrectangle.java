class Solution {
    public int solution(int[][] sizes) {
        
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            int big = Math.max(w, h);
            int small = Math.min(w, h);
            
            maxWidth = Math.max(maxWidth, big);
            maxHeight = Math.max(maxHeight, small);
        }
        
        return maxWidth * maxHeight;
    }
}
